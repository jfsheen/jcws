package cc.aisc.sys.service.impl;

import cc.aisc.core.base.AbstractService;
import cc.aisc.sys.mapper.MenuMapper;
import cc.aisc.sys.model.Menu;
import cc.aisc.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-4-24.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu, Integer> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
/*


    public Optional<Menu> findById(Integer id){
        return Optional.ofNullable(menuMapper.findById(id));
    }
*/

    @Override
    public Optional<List<Menu>> findAll() {
        return Optional.ofNullable(menuMapper.selectValid());
    }
}
