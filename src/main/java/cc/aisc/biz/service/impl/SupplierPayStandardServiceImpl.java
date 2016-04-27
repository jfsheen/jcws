package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.SupplierPayStandard;
import cc.aisc.biz.service.SupplierPayStandardService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class SupplierPayStandardServiceImpl extends AbstractService<SupplierPayStandard, Integer> implements SupplierPayStandardService {
}
