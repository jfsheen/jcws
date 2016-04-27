package cc.aisc.web.api.v1;

import cc.aisc.sys.model.Menu;
import cc.aisc.biz.service.FuelPriceService;
import cc.aisc.sys.service.MenuService;
import cc.aisc.sys.vo.MenuTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by sjf on 16-4-24.
 */
@RestController
@RequestMapping("/sys/api/v1")
public class SystemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private MenuService menuService;
    @Autowired
    private FuelPriceService fuelPriceService;

    @SuppressWarnings("unchecked")
    @RequestMapping("/1000")
    public List<Object> getMenuJson(){
        MenuTree menuTree = new MenuTree();
        try{
            List<Menu> menuList = menuService.findAll().get();
            menuTree.listMenuMap(menuList);
            Map<String, Object> map = (LinkedHashMap<String, Object>) menuTree.list.get(0);
            List<Object> list = new ArrayList<>();
            list.addAll((List<Object>) map.get("submenu"));
            map.remove("submenu");
            list.add(0, map);
            return list;
        }catch (NoSuchElementException e){
            LOGGER.info("No menu exists!");
        }catch (ClassCastException e){
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "/1001", method = RequestMethod.GET)
    public BigDecimal queryFuelPrice(@RequestParam Date anydate){
        return fuelPriceService.findByDate(anydate).get();
    }

    @RequestMapping(value = "/1002", method = RequestMethod.POST)
    public int addFuelPrice(@RequestParam Date start, @RequestParam Date end, @RequestParam BigDecimal price){
        return 0;
    }
}
