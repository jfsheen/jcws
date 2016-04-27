package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.OwnTruck;
import cc.aisc.biz.service.OwnTruckService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class OwnTruckServiceImpl extends AbstractService<OwnTruck, Integer> implements OwnTruckService {
}
