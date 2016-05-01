package cc.aisc.auth.service.impl;

import cc.aisc.auth.model.Role;
import cc.aisc.auth.model.User;
import cc.aisc.auth.service.UserService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by sjf on 16-4-27.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {
    @Override
    public Optional<Set<String>> findRoles(String username) {
        return null;
    }

    @Override
    public Optional<Set<String>> findPermissions(String username) {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return null;
    }
}
