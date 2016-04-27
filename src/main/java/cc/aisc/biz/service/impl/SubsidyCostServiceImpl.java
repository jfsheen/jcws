package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.SubsidyCost;
import cc.aisc.biz.service.SubsidyCostService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class SubsidyCostServiceImpl extends AbstractService<SubsidyCost, Integer> implements SubsidyCostService {
}
