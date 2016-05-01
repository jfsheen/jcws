package cc.aisc.sys.mapper;

import cc.aisc.core.base.BaseMapper;
import cc.aisc.sys.model.Menu;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu, Integer>{

    @Cacheable(value = "validMenuCache", keyGenerator = "redisKeyGenerator")
    List<Menu> selectValidByLevelLe(Integer lvl);
}