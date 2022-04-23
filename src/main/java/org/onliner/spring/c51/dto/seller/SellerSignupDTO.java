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
public class SellerSignupDTO {
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\"\\s]*$",
            message = "Name of a legal entity must contain only letters and quotation mark!")
    private String legalEntityName;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9:\\s,\\.]+$",
            message = "Legal address must contain only numbers, letters, periods, commas and and whitespaces!")
    private String stateRegistrationLegalEntityPlace;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[0-9]{9}$",
            message = "Payer account number must contain only 9 digits!")
    private String payerAccountNumber;

    @Past(message = "Date of state registration must be before the current date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stateRegistrationDate;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "(?:^[a-zA-Z\\s]*$)",
            message = "Registration authority must contain only letters and spaces!")
    private String registrationAuthority;

    @Past(message = "Date of registration in the commercial register must be before the current date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryTradeRegisterDate;

}
