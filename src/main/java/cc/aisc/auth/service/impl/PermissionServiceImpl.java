package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.Permission;
import cc.aisc.auth.service.PermissionService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class PermissionServiceImpl extends AbstractService<Permission, Integer> implements PermissionService {
}
