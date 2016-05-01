package cc.aisc.biz.service;

import cc.aisc.biz.model.RouteDistance;
import cc.aisc.core.base.BaseService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
public interface RouteDistanceService extends BaseService<RouteDistance, Integer> {
    Optional<List<Map<String, Object>>> findByLoc(String from, String to);
}
