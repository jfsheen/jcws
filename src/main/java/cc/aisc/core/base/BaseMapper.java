package cc.aisc.core.base;

import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by sjf on 16-4-26.
 */
public interface BaseMapper<T, ID extends Serializable> {
    int deleteByPrimaryKey(ID id);
    int insert(T record);
    int insertSelective(T record);
    //@Cacheable(value = "selectByPKCache", keyGenerator = "redisKeyGenerator")
    T selectByPrimaryKey(ID id);
    int updateByPrimaryKeySelective(T record);
    int updateByPrimaryKeyWithBlobs(T record);
    int updateByPrimaryKey(T record);
    Collection<T> selectAll();
}
