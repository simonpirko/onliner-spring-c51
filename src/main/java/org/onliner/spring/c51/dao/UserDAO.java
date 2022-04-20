package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Role;
import org.onliner.spring.c51.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserDAO extends GenericEntityDAO<User> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(int id);

    Optional<User> findByEmailForSellerFeedback(String email);

    Optional<User> findByEmailWithRoles(String email);

    List<User> findAllWithRoles();

    void assignRolesToUser(User user, Set<Role> roles);
}
