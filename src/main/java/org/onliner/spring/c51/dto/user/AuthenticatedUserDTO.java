package org.onliner.spring.c51.dto.user;

import org.onliner.spring.c51.entity.Role;

import java.util.Set;
import java.util.function.Predicate;


public class AuthenticatedUserDTO {
    private long id;
    private Set<Role> roles;
    private boolean admin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        if (roles != null && !roles.isEmpty()) {
            admin = roles.stream().map(Role::getName).anyMatch(Predicate.isEqual(Role.ROLE_ADMIN));
        }
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
