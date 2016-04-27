package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.Carrier;
import cc.aisc.biz.service.CarrierService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class CarrierServiceImpl extends AbstractService<Carrier, Integer> implements CarrierService {
}
