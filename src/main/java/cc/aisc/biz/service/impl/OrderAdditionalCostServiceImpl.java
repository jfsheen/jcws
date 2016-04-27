package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.OrderAdditionalCost;
import cc.aisc.biz.service.OrderAdditionalCostService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class OrderAdditionalCostServiceImpl extends AbstractService<OrderAdditionalCost, Integer> implements OrderAdditionalCostService {
}
