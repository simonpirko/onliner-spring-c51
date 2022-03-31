package org.onliner.spring.c51.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data                                   // ONL-12 : lombok
@NoArgsConstructor                      // ONL-12 : lombok
@AllArgsConstructor                     // ONL-12 : lombok
@Builder                                // ONL-12 : lombok
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

}
