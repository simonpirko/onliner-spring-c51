package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name = "User.findByEmailWithRoles", query = "SELECT u FROM User u JOIN FETCH u.roles WHERE u.email = :email"),
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findAllWithRoles", query = "SELECT u FROM User u JOIN FETCH u.roles r"),
        @NamedQuery(name = "User.exists", query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
})

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    @EqualsAndHashCode.Include
    private String email;
    private String password;
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();


    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }
}