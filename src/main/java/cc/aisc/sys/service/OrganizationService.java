package cc.aisc.sys.service;

import cc.aisc.core.base.BaseService;
import cc.aisc.sys.model.Organization;

import java.util.Optional;

/**
 * Created by sjf on 16-5-1.
 */
public interface OrganizationService extends BaseService<Organization, Integer>{
    Optional<Organization> findTreeDataById(Integer nid);
}
