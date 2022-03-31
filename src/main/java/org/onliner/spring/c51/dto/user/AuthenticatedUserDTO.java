package org.onliner.spring.c51.dto.user;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.onliner.spring.c51.entity.Role;

import java.util.Set;
import java.util.function.Predicate;

// ONL-12 : lombok

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthenticatedUserDTO {
    private long id;
    @Setter(AccessLevel.NONE)
    private Set<Role> roles;
    private boolean admin;



    // ONL-12 : lombok
    public void setRoles(Set<Role> roles) {
        if (roles != null && !roles.isEmpty()) {
            admin = roles.stream().map(Role::getName).anyMatch(Predicate.isEqual(Role.ROLE_ADMIN));
        }
        this.roles = roles;
    }


}
