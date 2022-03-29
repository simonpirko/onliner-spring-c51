package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Role;

import java.util.Optional;

public interface RoleDAO extends GenericEntityDAO<Role> {

    Optional<Role> findByName(String name);
}
