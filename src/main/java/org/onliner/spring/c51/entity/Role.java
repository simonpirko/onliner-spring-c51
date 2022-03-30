package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Role.exists", query = "SELECT r FROM Role r WHERE r.name = :name"),
        @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name"),
        @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
})

@Data                                               // ONL-12 : lombok
@NoArgsConstructor                                  // ONL-12 : lombok
@AllArgsConstructor                                 // ONL-12 : lombok
@EqualsAndHashCode(onlyExplicitlyIncluded = true)   // ONL-12 : lombok
@Entity
@Table
public class Role {
    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @EqualsAndHashCode.Include                      // ONL-12 : lombok
    private String name;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude                               // ONL-12 : lombok
    private Set<User> users = new HashSet<>();


    public Role(String name) {
        this.name = name;
    }

}
