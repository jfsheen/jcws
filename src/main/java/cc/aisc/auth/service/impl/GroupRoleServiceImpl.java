package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.GroupRole;
import cc.aisc.auth.service.GroupRoleService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class GroupRoleServiceImpl extends AbstractService<GroupRole, Integer> implements GroupRoleService {
}
