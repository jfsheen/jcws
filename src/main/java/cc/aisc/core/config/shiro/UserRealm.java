package cc.aisc.core.config.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

/**
 * Created by sjf on 16-4-21.
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    /*@Autowired
    UserService userService;*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        String loginName = (String)principalCollection.getPrimaryPrincipal();
        //到数据库查是否有此对象
        try {
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//            User user = userService.findByUsername(loginName).get();
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            //用户的角色集合
//            info.setRoles(userService.getRoles(user));
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            /*List<Role> roleList=user.getRoleList();
            for (Role role : roleList) {
                info.addStringPermissions(role.getPermissionsName());
            }*/
            // 或者按下面这样添加
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
            //simpleAuthorInfo.addRole("admin");
            //添加权限
            //simpleAuthorInfo.addStringPermission("admin:manage");
            //logger.info("已为用户[mike]赋予了[admin]角色和[admin:manage]权限");
            return info;
        }catch (NoSuchElementException e){
            logger.warn("no record by username = {}", loginName);
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {/*
        String loginUser = (String)authenticationToken.getPrincipal();
        try {
            User user = userService.findByUsername(loginUser).get();
            if (Boolean.FALSE.equals(user.getEnable())){
                throw new LockedAccountException();
            }
            return new SimpleAuthenticationInfo(
                    user.getUsername(), //用户名
                    user.getPassword(), //密码
                    ByteSource.Util.bytes(userService.getCredentialsSalt(user)),//salt=username+salt
                    getName() //realm name
            );
        }catch (NoSuchElementException e){
            throw new UnknownAccountException();
        }*/
        return null;
    }
}
