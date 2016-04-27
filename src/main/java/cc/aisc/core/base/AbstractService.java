package cc.aisc.core.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
public abstract class AbstractService<T, ID extends Serializable> implements BaseService<T, ID>{


    @Autowired
    private BaseMapper<T, ID> baseMapper;

    public BaseMapper<T, ID> getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int delete(ID id) {
        return this.baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return this.baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return this.baseMapper.insertSelective(record);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(this.baseMapper.selectByPrimaryKey(id));
    }

    @Override
    public int updateSelective(T record) {
        return this.baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateWithBlobs(T record) {
        return this.baseMapper.updateByPrimaryKeyWithBlobs(record);
    }

    @Override
    public int update(T record) {
        return this.baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public Optional<Collection<T>> findAll(){
        return Optional.ofNullable(baseMapper.selectAll());
    }
}
