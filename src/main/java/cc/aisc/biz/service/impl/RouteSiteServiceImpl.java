package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.RouteSite;
import cc.aisc.biz.service.RouteSiteService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class RouteSiteServiceImpl extends AbstractService<RouteSite, Integer> implements RouteSiteService {
}
