package org.onliner.spring.c51.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Objects;

@Data                                   // ONL-12 : lombok
@NoArgsConstructor                      // ONL-12 : lombok
@AllArgsConstructor                     // ONL-12 : lombok
@Builder                                // ONL-12 : lombok
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


}
