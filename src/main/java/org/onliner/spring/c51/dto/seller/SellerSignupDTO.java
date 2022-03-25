package org.onliner.spring.c51.dto.seller;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import java.util.Date;

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

    public String getLegalEntityName() {
        return legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) {
        this.legalEntityName = legalEntityName;
    }

    public String getStateRegistrationLegalEntityPlace() {
        return stateRegistrationLegalEntityPlace;
    }

    public void setStateRegistrationLegalEntityPlace(String stateRegistrationLegalEntityPlace) {
        this.stateRegistrationLegalEntityPlace = stateRegistrationLegalEntityPlace;
    }

    public String getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(String payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }

    public Date getStateRegistrationDate() {
        return stateRegistrationDate;
    }

    public void setStateRegistrationDate(Date stateRegistrationDate) {
        this.stateRegistrationDate = stateRegistrationDate;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public Date getEntryTradeRegisterDate() {
        return entryTradeRegisterDate;
    }

    public void setEntryTradeRegisterDate(Date entryTradeRegisterDate) {
        this.entryTradeRegisterDate = entryTradeRegisterDate;
    }
}
