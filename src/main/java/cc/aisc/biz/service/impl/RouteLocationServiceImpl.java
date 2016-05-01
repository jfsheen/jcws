package cc.aisc.biz.service.impl;

import cc.aisc.biz.mapper.RouteDistanceMapper;
import cc.aisc.biz.model.RouteLocation;
import cc.aisc.biz.service.RouteLocationService;
import cc.aisc.core.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class RouteLocationServiceImpl extends AbstractService<RouteLocation, Integer> implements RouteLocationService {


}
