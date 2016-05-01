package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.Resource;
import cc.aisc.auth.service.ResourceService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class ResourceServiceImpl extends AbstractService<Resource, Integer> implements ResourceService {
}
