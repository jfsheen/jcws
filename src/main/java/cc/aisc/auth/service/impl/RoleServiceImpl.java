package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.Role;
import cc.aisc.auth.service.RoleService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role, Integer> implements RoleService {
}
