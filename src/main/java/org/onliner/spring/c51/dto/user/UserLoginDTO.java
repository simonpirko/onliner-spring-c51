package org.onliner.spring.c51.dto.user;

import org.hibernate.validator.constraints.Email;

public class UserLoginDTO {

    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    private String email;

    private String password;

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
