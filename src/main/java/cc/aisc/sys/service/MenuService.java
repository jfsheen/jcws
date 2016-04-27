package cc.aisc.sys.service;

import cc.aisc.core.base.BaseService;
import cc.aisc.sys.model.Menu;

import java.util.List;
import java.util.Optional;

/**
 * Created by sjf on 16-4-24.
 */
public interface MenuService extends BaseService<Menu, Integer> {
    //Optional<Menu> findById(Integer id);
    Optional<List<Menu>> findAll();
}
