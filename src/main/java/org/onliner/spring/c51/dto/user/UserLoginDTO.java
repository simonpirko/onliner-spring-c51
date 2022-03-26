package org.onliner.spring.c51.dto.user;

import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginDTO {
    @NotNull
    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    @Size (min = 3, max = 100, message = "Email введен некоректно, проверьте правильность ввода и " +
            " повторите попытку")
    private String email;

    @NotNull
    @Size(min = 6, max = 10, message = "Пароль введен некоректно,проверьте правильность ввода и " +
            " повторите попытку еще раз")
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
