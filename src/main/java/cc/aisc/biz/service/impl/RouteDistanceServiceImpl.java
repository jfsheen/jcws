package cc.aisc.biz.service.impl;

import cc.aisc.biz.mapper.RouteDistanceMapper;
import cc.aisc.biz.model.RouteDistance;
import cc.aisc.biz.service.RouteDistanceService;
import cc.aisc.core.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class RouteDistanceServiceImpl extends AbstractService<RouteDistance, Integer> implements RouteDistanceService {

    @Autowired
    private RouteDistanceMapper routeDistanceMapper;

    /*@Override
    public Optional<List<Map<String, Object>>> findByLoc(Map<String, String> param) {
        return Optional.ofNullable(routeDistanceMapper.selectByLoc(param));
    }*/

    @Override
    public Optional<List<Map<String, Object>>> findByLoc(String from, String to) {
        return Optional.ofNullable(routeDistanceMapper.selectByLoc(from, to));
    }
}
