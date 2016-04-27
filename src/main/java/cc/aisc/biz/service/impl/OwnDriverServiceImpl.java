package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.OwnDriver;
import cc.aisc.biz.service.OwnDriverService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class OwnDriverServiceImpl extends AbstractService<OwnDriver, Integer> implements OwnDriverService {
}
