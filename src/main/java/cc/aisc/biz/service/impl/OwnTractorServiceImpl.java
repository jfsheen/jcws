package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.OwnTractor;
import cc.aisc.biz.service.OwnTractorService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class OwnTractorServiceImpl extends AbstractService<OwnTractor, Integer> implements OwnTractorService {
}
