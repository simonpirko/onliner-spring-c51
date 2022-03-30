package org.onliner.spring.c51.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name = "User.findByEmailWithRoles", query = "SELECT u FROM User u JOIN FETCH u.roles WHERE u.email = :email"),
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findAllWithRoles", query = "SELECT u FROM User u JOIN FETCH u.roles r"),
        @NamedQuery(name = "User.exists", query = "SELECT u FROM User u WHERE u.email = :email")
})
@Data                       // ONL-12 : lombok
@NoArgsConstructor          // ONL-12 : lombok
@AllArgsConstructor         // ONL-12 : lombok
@Builder                    // ONL-12 : lombok
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();




    public static class Builder {
        private long builderId;
        private String builderFirstName;
        private String builderLastName;
        private String builderUsername;
        private String builderEmail;
        private String builderPassword;
        private Set<Role> builderRoles;

        public Builder() {
        }

        public Builder id(long id) {
            builderId = id;
            return this;
        }

        public Builder firstName(String firstName) {
            builderFirstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            builderLastName = lastName;
            return this;
        }

        public Builder username(String username) {
            builderUsername = username;
            return this;
        }

        public Builder email(String email) {
            builderEmail = email;
            return this;
        }

        public Builder password(String password) {
            builderPassword = password;
            return this;
        }

        public Builder roles(Set<Role> roles) {
            builderRoles = roles;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }
}
