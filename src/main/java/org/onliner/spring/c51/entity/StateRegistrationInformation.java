package org.onliner.spring.c51.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * legalEntityName - наименование юридического лица
 * stateRegistrationLegalEntityPlace - место государственной регистрации юридического лица
 * payerRegistrationNumber - УНП
 * registrationNumber - регистрационный номер
 * registrationAuthority - регистрирующий орган
 * entryTradeRegisterDate - зарегистрирован в торговом реестре
 */

@Data                                                   // ONL-12 : lombok
@NoArgsConstructor                                      // ONL-12 : lombok
@EqualsAndHashCode(onlyExplicitlyIncluded = true)       // ONL-12 : lombok
@Entity
@Table(name = "state_registration_information")
public class StateRegistrationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private LocalDateTime creationDateTime = LocalDateTime.now();
    private LocalDateTime updateDateTime = LocalDateTime.now();
    private String legalEntityName;
    private String stateRegistrationLegalEntityPlace;
    @EqualsAndHashCode.Include                          // ONL-12 : lombok
    private int payerAccountNumber;
    private LocalDate stateRegistrationDate;
    private String registrationAuthority;
    private LocalDate entryTradeRegisterDate;
    @OneToOne
    private Seller seller;

    public StateRegistrationInformation(String legalEntityName, String stateRegistrationLegalEntityPlace,
                                        int payerAccountNumber, LocalDate stateRegistrationDate,
                                        String registrationAuthority, LocalDate entryTradeRegisterDate) {
        this.legalEntityName = legalEntityName;
        this.stateRegistrationLegalEntityPlace = stateRegistrationLegalEntityPlace;
        this.payerAccountNumber = payerAccountNumber;
        this.stateRegistrationDate = stateRegistrationDate;
        this.registrationAuthority = registrationAuthority;
        this.entryTradeRegisterDate = entryTradeRegisterDate;
    }
}
