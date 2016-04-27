package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.Supplier;
import cc.aisc.biz.service.SupplierService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class SupplierServiceImpl extends AbstractService<Supplier, Integer> implements SupplierService {
}
