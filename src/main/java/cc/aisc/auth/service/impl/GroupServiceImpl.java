package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.Group;
import cc.aisc.auth.service.GroupService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class GroupServiceImpl extends AbstractService<Group, Integer> implements GroupService {
}
