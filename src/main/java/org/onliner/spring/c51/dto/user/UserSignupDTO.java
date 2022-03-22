package org.onliner.spring.c51.dto.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserSignupDTO {
    @NotNull
    @NotBlank
    @Length(min = 2)
    @Pattern(regexp = "^([А-Я][а-яё]{1,23}|[A-Z][a-z]{1,23})$")
    private String firstName;

    @NotNull
    @NotBlank
    @Length (min = 2)
    @Pattern(regexp = "^([А-Я][а-яё]{1,23}|[A-Z][a-z]{1,23})$")
    private String lastName;

    @NotNull
    @NotBlank
    @Length(min = 2)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{1,20}$")
    private String username;

    @NotNull
    @NotBlank
    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    @Length(min = 3, max = 100)
    private String email;

    @NotNull
    @NotBlank
    @Length(min = 6, max = 10)
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
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
