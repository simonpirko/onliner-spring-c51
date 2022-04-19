package org.onliner.spring.c51.dto.user;

import lombok.*;
import org.onliner.spring.c51.entity.Role;

import java.util.Set;
import java.util.function.Predicate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthenticatedUserDTO {
    private long id;
    @Setter(AccessLevel.NONE)
    private Set<Role> roles;
    private boolean admin;
    private boolean manager;

    public void setRoles(Set<Role> roles) {
        if (roles != null && !roles.isEmpty()) {
//            admin = roles.stream().map(Role::getName).anyMatch(Predicate.isEqual(Role.ROLE_ADMIN));
            admin = roles.contains(Role.builder().name(Role.ROLE_ADMIN).build());
            manager = roles.contains(Role.builder().name(Role.ROLE_MANAGER).build());
        }
        this.roles = roles;
    }
}
