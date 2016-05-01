package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.Dealer;
import cc.aisc.biz.service.DealerService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class DealerServiceImpl extends AbstractService<Dealer, Integer> implements DealerService {
}
