package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.UserRole;
import cc.aisc.auth.service.UserRoleService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole, Integer> implements UserRoleService {
}
