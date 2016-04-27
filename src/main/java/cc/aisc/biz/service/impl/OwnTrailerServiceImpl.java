package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.OwnTrailer;
import cc.aisc.biz.service.OwnTrailerService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class OwnTrailerServiceImpl extends AbstractService<OwnTrailer, Integer> implements OwnTrailerService {
}
