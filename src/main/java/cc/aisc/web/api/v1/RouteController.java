package cc.aisc.web.api.v1;

import cc.aisc.biz.service.RouteDistanceService;
import cc.aisc.biz.service.RouteSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sjf on 16-4-27.
 */
@RestController
@RequestMapping("/rut/api/v1")
public class RouteController {

    private final RouteDistanceService routeDistanceService;
    private final RouteSiteService routeSiteService;

    @Autowired
    public RouteController(RouteDistanceService routeDistanceService, RouteSiteService routeSiteService) {
        this.routeDistanceService = routeDistanceService;
        this.routeSiteService = routeSiteService;
    }
}
