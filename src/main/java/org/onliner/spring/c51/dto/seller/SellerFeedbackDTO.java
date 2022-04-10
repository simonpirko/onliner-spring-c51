package org.onliner.spring.c51.dto.seller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data                                   // ONL-12 : lombok
@NoArgsConstructor                      // ONL-12 : lombok
@AllArgsConstructor                     // ONL-12 : lombok
@Builder                                // ONL-12 : lombok
public class SellerFeedbackDTO {
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\"\\s]*$",
            message = "Title of a legal entity must contain only letters and quotation mark!")
    private String title;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9:\\s,\\.]+$",
            message = "Legal address must contain only numbers, letters, periods, commas and and whitespaces!")
    private String description;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\"\\s]*$",
            message = "Name of a legal entity must contain only letters and quotation mark!")
    private String grade;

    @Past(message = "Date of state registration must be before the current date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userName;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "(?:^[a-zA-Z\\s]*$)",
            message = "Registration authority must contain only letters and spaces!")
    private String sellerName;

}
