package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.SupplierPayDistance;
import cc.aisc.biz.service.SupplierPayDistanceService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class SupplierPayDistanceServiceImpl extends AbstractService<SupplierPayDistance, Integer> implements SupplierPayDistanceService {
}
