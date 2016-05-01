package cc.aisc.web.api.v1;

import cc.aisc.core.helper.TreeHelper;
import cc.aisc.sys.model.Menu;
import cc.aisc.biz.service.FuelPriceService;
import cc.aisc.sys.model.Organization;
import cc.aisc.sys.service.MenuService;
import cc.aisc.sys.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private OrganizationService organizationService;

    @SuppressWarnings("unchecked")
    @RequestMapping("/menu/{lvl}")
    public List<Object> getMenuList(@PathVariable Integer lvl){
        try{
            List<Menu> menuList = (ArrayList<Menu>)menuService.findValidByLvlLe(lvl).get();
            TreeHelper helper = new TreeHelper<Menu>();
            return helper.getTree(menuList);
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

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/organ", method = RequestMethod.GET)
    public List<Organization> getTreeNodeData(){
        try {
            List<Organization> lists = (ArrayList<Organization>) organizationService.findAll().get();
            TreeHelper helper = new TreeHelper<Organization>();
            return helper.getTree(lists);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }
}
