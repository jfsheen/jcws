package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.UserGroup;
import cc.aisc.auth.service.UserGroupService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class UserGroupServiceImpl extends AbstractService<UserGroup, Integer> implements UserGroupService {
}
