package cc.aisc.sys.service.impl;

import cc.aisc.core.base.AbstractService;
import cc.aisc.sys.mapper.OrganizationMapper;
import cc.aisc.sys.model.Organization;
import cc.aisc.sys.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by sjf on 16-5-1.
 */
@Service
@Transactional
public class OrganizationServiceImpl extends AbstractService<Organization, Integer> implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public Optional<Organization> findTreeDataById(Integer nid) {
        return Optional.ofNullable(organizationMapper.selectTreeData(nid));
    }
}
