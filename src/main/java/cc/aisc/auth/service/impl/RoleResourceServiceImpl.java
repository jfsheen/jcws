package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.RoleResource;
import cc.aisc.auth.service.RoleResourceService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class RoleResourceServiceImpl extends AbstractService<RoleResource, Integer> implements RoleResourceService {
}
