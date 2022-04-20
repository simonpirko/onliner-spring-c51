package org.onliner.spring.c51.dto.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerFeedbackDTO {
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\"\\s]*$",
            message = "Title of a legal entity must contain only letters and quotation mark!")
    private String title;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9:\\s,\\.]+$",
            message = "Description must contain only numbers, letters, periods, commas and and whitespaces!")
    private String description;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9:\\s,\\.]+$",
            message = "Grade must contain only numbers, letters, periods, commas and and whitespaces!")
    private String grade;

//    @NotBlank
//    @NotEmpty
//    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
//    @Size(min = 3, max = 100, message = "Email введен некоректно, проверьте правильность ввода и " +
//            " повторите попытку")
    private User user;

//    @NotBlank
//    @NotEmpty
//    @Pattern(regexp = "^[0-9]{9}$",
//            message = "Payer account number must contain only 9 digits!")
    private Seller seller;

}
