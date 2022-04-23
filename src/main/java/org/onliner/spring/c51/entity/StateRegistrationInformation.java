package org.onliner.spring.c51.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * legalEntityName - наименование юридического лица
 * stateRegistrationLegalEntityPlace - место государственной регистрации юридического лица
 * payerRegistrationNumber - УНП
 * registrationNumber - регистрационный номер
 * registrationAuthority - регистрирующий орган
 * entryTradeRegisterDate - зарегистрирован в торговом реестре
 */

@Entity
@Table(name = "state_registration_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class StateRegistrationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String legalEntityName;

    private String stateRegistrationLegalEntityPlace;

    @EqualsAndHashCode.Include
    private int payerAccountNumber;

    private LocalDate stateRegistrationDate;

    private String registrationAuthority;

    private LocalDate entryTradeRegisterDate;

    @OneToOne
    private Seller seller;
        }

