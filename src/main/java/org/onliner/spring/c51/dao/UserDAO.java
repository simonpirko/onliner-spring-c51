package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.User;

import java.util.Optional;

public interface UserDAO extends GenericEntityDAO<User> {

    Optional<User> findByEmail(String email);
}
