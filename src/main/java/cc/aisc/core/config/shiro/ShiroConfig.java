package cc.aisc.core.config.shiro;

import cc.aisc.core.config.shiro.filters.RoleAuthorizationFilter;
import cc.aisc.core.config.shiro.redis.RedisCacheManager;
import cc.aisc.core.config.shiro.redis.RedisManager;
import cc.aisc.core.config.shiro.redis.RedisSessionDAO;
import cc.aisc.core.config.shiro.realm.UserRealm;
import cc.aisc.core.config.shiro.support.CustomShiroFilterFactoryBean;
import cc.aisc.core.config.shiro.support.RetryLimitHashedCredentialsMatcher;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    private final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    /* todo
    @Bean JedisPoolConfig
    @Bean JedisPool
    @Bean JedisPoolManager
    ===>inject cacheManager;
    * */

    @Bean(name="redisManager")
    public RedisManager redisManager(){
        return new RedisManager();
    }

    @Bean(name = "shiroCacheManager")
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager cacheManager = new RedisCacheManager();
        cacheManager.setRedisManager(redisManager());
        return cacheManager;
    }

    @Bean(name = "sessionIdGenerator")
    public JavaUuidSessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }

    @Bean(name = "redisSessionDAO")
    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO sessionDAO = new RedisSessionDAO();
        sessionDAO.setSessionIdGenerator(sessionIdGenerator());
        sessionDAO.setKeyPrefix("redis_cache-prefix:");
        sessionDAO.setRedisManager(redisManager());
        return sessionDAO;
    }

    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        UserRealm realm = new UserRealm();
        realm.setCacheManager(redisCacheManager());
        realm.setCredentialsMatcher(credentialsMatcher());
        realm.setCachingEnabled(true);
        realm.setAuthenticationCachingEnabled(true);
        realm.setAuthenticationCacheName("authenticationCache");
        realm.setAuthorizationCachingEnabled(true);
        realm.setAuthorizationCacheName("authorizationCache");
        return realm;
    }

    @Bean(name = "credentialsMatcher")
    public RetryLimitHashedCredentialsMatcher credentialsMatcher(){
        RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(redisCacheManager());
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean(name = "sessionIdCookie")
    public SimpleCookie simpleCookie(){
        SimpleCookie  simpleCookie = new SimpleCookie("SHAREDSESSION");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }

    @Bean(name = "sessionManager")
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setCacheManager(redisCacheManager());
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // use default scheduler
        //sessionManager.setSessionValidationScheduler(sessionValidationScheduler());
        sessionManager.setSessionDAO(redisSessionDAO());
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(simpleCookie());
        return sessionManager;
    }

    /*@Bean(name = "sessionValidatorScheduler")
    public QuartzSessionValidationScheduler sessionValidationScheduler() {
        QuartzSessionValidationScheduler svs = new QuartzSessionValidationScheduler();
        svs.setSessionValidationInterval(1800000);
        return svs;
    }*/

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(redisCacheManager());
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie(){
        SimpleCookie cookie = new SimpleCookie();
        cookie.setMaxAge(2592000);
        cookie.setHttpOnly(true);
        return cookie;
    }
    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager cookieRememberMeManager(){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        rememberMeManager.setCookie(rememberMeCookie());
        return rememberMeManager;
    }
    //开启权限注解功能
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager());
        return aasa;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new CustomShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403.html");
        loadShiroFilterChain(shiroFilterFactoryBean);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationFilter roleAuthorizationFilter(){
        AuthorizationFilter filter = new RoleAuthorizationFilter();
        filter.setLoginUrl("login.html");
        return filter;//set response message
    }

    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        FormAuthenticationFilter faf = new FormAuthenticationFilter();
        faf.setUsernameParam("username");
        faf.setPasswordParam("password");
        faf.setRememberMeParam("rememberme");
        faf.setLoginUrl("/login.html");
        return faf;
    }

    /**
     * 加载shiroFilter权限控制规则（从数据库读取然后配置）
     * @author SHANHY
     * @create 2016年1月14日
     */
    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean){
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/login.html", "anon");
        filterChainDefinitionMap.put("/reg.html", "anon");
        filterChainDefinitionMap.put("/sys/**", "anon");
        filterChainDefinitionMap.put("/**", "authc"); //放在最后，否则以上anon无效
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        Map<String, Filter> filters = new HashMap<>();
        filters.put("role", roleAuthorizationFilter());
        //filters.put("authc", formAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filters);
    }


}
