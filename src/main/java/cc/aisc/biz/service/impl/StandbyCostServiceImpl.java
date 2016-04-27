package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.StandbyCost;
import cc.aisc.biz.service.StandbyCostService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class StandbyCostServiceImpl extends AbstractService<StandbyCost, Integer> implements StandbyCostService {
}
