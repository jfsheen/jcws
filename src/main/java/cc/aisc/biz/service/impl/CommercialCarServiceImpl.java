package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.CommercialCar;
import cc.aisc.biz.service.CommercialCarService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class CommercialCarServiceImpl extends AbstractService<CommercialCar, Integer> implements CommercialCarService {

}
