package org.onliner.spring.c51.dto.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Objects;

public class UserSignupDTO {
    @NotNull
    @NotBlank
    @Length(min = 2, message = "Длина должна быть минимум 2 символа")
    @Pattern(regexp = "^([А-Я][а-яё]{1,23}|[A-Z][a-z]{1,23})$", message = "Имя должно состоять только из латинских букв " +
            " и кириллицы")
    private String firstName;

    @NotNull
    @NotBlank
    @Length (min = 2, message = "Длина должна быть минимум 2 символа")
    @Pattern(regexp = "^([А-Я][а-яё]{1,23}|[A-Z][a-z]{1,23})$", message = "Фамилия должна состоять только из латинских букв " +
            "и кириллицы")
    private String lastName;

    @NotNull
    @NotBlank
    @Length(min = 2, message = "Длина должна быть минимум 2 символа")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{1,20}$", message = "Имя пользователя должно только состоять из латинских букв, " +
            " кириллицы и цифр")
    private String username;

    @NotNull
    @NotBlank
    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    @Length(min = 3, max = 100)
    private String email;

    @NotNull
    @NotBlank
    @Length(min = 6, max = 10, message = "Длина должна быть минимум 6 символов и масимум 8")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "пароль " +
            "должен состоять только из букв, цифр, длиною не более 8 символов")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignupDTO that = (UserSignupDTO) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(username, that.username) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, email, password);
    }
}
