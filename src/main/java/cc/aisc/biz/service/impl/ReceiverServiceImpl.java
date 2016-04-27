package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.Receiver;
import cc.aisc.biz.service.ReceiverService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class ReceiverServiceImpl extends AbstractService<Receiver, Integer> implements ReceiverService {
}
