package org.onliner.spring.c51.entity;

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

    public User() {
    }

    private User(Builder builder) {
        this.id = builder.builderId;
        this.firstName = builder.builderFirstName;
        this.lastName = builder.builderLastName;
        this.username = builder.builderUsername;
        this.email = builder.builderEmail;
        this.password = builder.builderPassword;
        this.roles = builder.builderRoles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static Builder builder() {
        return new Builder();
    }

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
