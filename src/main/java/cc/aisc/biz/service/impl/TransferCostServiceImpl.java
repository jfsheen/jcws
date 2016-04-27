package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.TransferCost;
import cc.aisc.biz.service.TransferCostService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class TransferCostServiceImpl extends AbstractService<TransferCost, Integer> implements TransferCostService {
}
