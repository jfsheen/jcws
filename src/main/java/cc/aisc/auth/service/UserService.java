package cc.aisc.auth.service;

import cc.aisc.auth.model.Role;
import cc.aisc.auth.model.User;
import cc.aisc.core.base.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by sjf on 16-4-27.
 */
public interface UserService extends BaseService<User, Integer>{
    Optional<Set<String>> findRoles(String username);
    Optional<Set<String>> findPermissions(String username);
    Optional<User> findByUsername(String username);
}
