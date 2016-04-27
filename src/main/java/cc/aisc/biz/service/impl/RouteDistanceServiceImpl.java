package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.RouteDistance;
import cc.aisc.biz.service.RouteDistanceService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class RouteDistanceServiceImpl extends AbstractService<RouteDistance, Integer> implements RouteDistanceService {
}
