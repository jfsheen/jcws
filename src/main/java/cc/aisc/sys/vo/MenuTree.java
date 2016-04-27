package cc.aisc.sys.vo;

import cc.aisc.sys.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by sjf on 16-4-24.
 */
public class MenuTree {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuTree.class);

    public static Map<String, Object> mapArray = new LinkedHashMap<>();
    public List<Menu> menuCommon;
    public List<Object> list = new ArrayList<>();

    public List<Object> listMenuMap(List<Menu> menus){
        this.menuCommon = menus;
        for (Menu menu : menus){
            Map<String, Object> map = new LinkedHashMap<>();
            if(Objects.equals(menu.getParentId(), 0)){
                map.put("id", menu.getId());
                map.put("text", menu.getText());
                map.put("tooltip", menu.getTooltip());
                map.put("level", menu.getLevel());
                map.put("sort", menu.getSort());
                map.put("heading", true);
                map.put("enabled", menu.getStatus());
                map.put("sref", menu.getSref());
                map.put("icon", menu.getIcon());
                map.put("translate", menu.getTranslate());
                map.put("submenu", getSubmenu(menu.getId()));
                list.add(map);
            }
        }
        return list;

    }

    public List<Object> getSubmenu(Integer id){
        List<Object> list = new ArrayList<>();
        for (Menu menu : menuCommon){
            Map<String, Object> map = new LinkedHashMap<>();
            if (Objects.equals(menu.getParentId(), id)){
                map.put("id", menu.getId());
                map.put("text", menu.getText());
                map.put("tooltip", menu.getTooltip());
                map.put("level", menu.getLevel());
                map.put("sort", menu.getSort());
                map.put("parentId", menu.getParentId());
                map.put("enabled", menu.getStatus());
                map.put("sref", menu.getSref());
                map.put("icon", menu.getIcon());
                map.put("translate", menu.getTranslate());
                map.put("submenu", getSubmenu(menu.getId()));
                list.add(map);
            }
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1 instanceof LinkedHashMap && o2 instanceof LinkedHashMap) {
                return (int)((Map<String, Object>) o1).get("sort") - (int)((Map<String, Object>) o2).get("sort");
            }
            return 0;
        });
        return list;
    }
}
