package org.onliner.spring.c51.entity;

import javax.persistence.*;

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

    public User() {
    }

    private User(Builder builder) {
        this.id = builder.builderId;
        this.firstName = builder.builderFirstName;
        this.lastName = builder.builderLastName;
        this.username = builder.builderUsername;
        this.email = builder.builderEmail;
        this.password = builder.builderPassword;
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

        public User build() {
            return new User(this);
        }
    }
}
