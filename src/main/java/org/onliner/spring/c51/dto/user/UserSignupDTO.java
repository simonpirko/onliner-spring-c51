package org.onliner.spring.c51.dto.user;

import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserSignupDTO {
    @NotNull
    @Size(min = 5)
    private String firstName;

    @NotNull
    @Size (min = 5)
    private String lastName;

    @NotNull
    @Size(min = 5)
    private String username;

    @NotNull
    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    @Size(min = 3, max = 100)
    private String email;

    @NotNull
    @Size(min = 6, max = 10)
    private String password;

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
}
