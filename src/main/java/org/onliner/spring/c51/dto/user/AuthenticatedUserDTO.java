package org.onliner.spring.c51.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.onliner.spring.c51.entity.Role;

import java.util.Set;
import java.util.function.Predicate;

@Data                                   // ONL-12 : lombok
@NoArgsConstructor                      // ONL-12 : lombok
@AllArgsConstructor                     // ONL-12 : lombok
@Builder                                // ONL-12 : lombok
public class AuthenticatedUserDTO {
    private long id;
    private Set<Role> roles;
    private boolean admin;




    public void setRoles(Set<Role> roles) {
        if (roles != null && !roles.isEmpty()) {
            admin = roles.stream().map(Role::getName).anyMatch(Predicate.isEqual(Role.ROLE_ADMIN));
        }
        this.roles = roles;
    }


}
