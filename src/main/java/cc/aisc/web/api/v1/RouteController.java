package cc.aisc.web.api.v1;

import cc.aisc.biz.service.RouteDistanceService;
import cc.aisc.biz.service.RouteLocationService;
import cc.aisc.core.commons.utils.StringUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by sjf on 16-4-27.
 */
@RestController
@RequestMapping("/rut/api/v1")
public class RouteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);
    private final RouteDistanceService routeDistanceService;
    private final RouteLocationService routeLocationService;

    @Autowired
    public RouteController(RouteDistanceService routeDistanceService, RouteLocationService routeLocationService) {
        this.routeDistanceService = routeDistanceService;
        this.routeLocationService = routeLocationService;
    }

    @RequestMapping(value = "/dist", method = RequestMethod.GET)
    public List<Map<String, Object>> getDist(@RequestParam("scope") String scope) throws UnsupportedEncodingException {
        if(StringUtils.isEmpty(scope)){
            LOGGER.info(" RouteController.getDist() : Args error, cannot be null or empty!");
            return null;
        }
        String from = "";
        String to = "";
        HashMap<String, String> param = new HashMap<String, String>(){
            {
                put("from", "");
                put("to", "");
            }
        };

        String p = URLDecoder.decode(scope, "utf-8");
        try {
            String[] arr = p.split(",");
            if (arr.length > 1){
                to = arr[1];
                param.put("to", arr[1]);
            }else if (arr.length == 1) {
                from = arr[0];
                param.put("from", arr[0]);
            }
            try {
                return routeDistanceService.findByLoc(from, to).get();
                //return routeDistanceService.findByLoc(param).get();
            }catch (NoSuchElementException e){
                LOGGER.info("No route from [{}] to [{}]!", param.get("from"), param.get("to"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
