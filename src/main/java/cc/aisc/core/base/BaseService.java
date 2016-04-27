package cc.aisc.core.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
public interface BaseService<T, ID extends Serializable> {
    int delete(ID id);
    int insert(T record);
    int insertSelective(T record);
    Optional<T> findById(ID id);
    int updateSelective(T record);
    int updateWithBlobs(T record);
    int update(T record);
    Optional<Collection<T>> findAll();
}
