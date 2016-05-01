package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.VehicleOverall;
import cc.aisc.biz.service.VehicleOverallService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class VehicleOverallServiceImpl extends AbstractService<VehicleOverall, Integer> implements VehicleOverallService {

}
