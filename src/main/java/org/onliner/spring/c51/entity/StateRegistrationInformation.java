package org.onliner.spring.c51.entity;

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
    private int payerAccountNumber;
    private LocalDate stateRegistrationDate;
    private String registrationAuthority;
    private LocalDate entryTradeRegisterDate;
    @OneToOne
    private Seller seller;

    public StateRegistrationInformation() {}

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

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

    public int getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(int payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }

    public LocalDate getStateRegistrationDate() {
        return stateRegistrationDate;
    }

    public void setStateRegistrationDate(LocalDate stateRegistrationDate) {
        this.stateRegistrationDate = stateRegistrationDate;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public LocalDate getEntryTradeRegisterDate() {
        return entryTradeRegisterDate;
    }

    public void setEntryTradeRegisterDate(LocalDate entryTradeRegisterDate) {
        this.entryTradeRegisterDate = entryTradeRegisterDate;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateRegistrationInformation that = (StateRegistrationInformation) o;
        return payerAccountNumber == that.payerAccountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payerAccountNumber);
    }

    @Override
    public String toString() {
        return "StateRegistrationInformation{" +
                "id=" + id +
                ", creationDateTime=" + creationDateTime +
                ", updateDateTime=" + updateDateTime +
                ", legalEntityName='" + legalEntityName + '\'' +
                ", stateRegistrationLegalEntityPlace='" + stateRegistrationLegalEntityPlace + '\'' +
                ", payerAccountNumber=" + payerAccountNumber +
                ", stateRegistrationDate=" + stateRegistrationDate +
                ", registrationAuthority='" + registrationAuthority + '\'' +
                ", entryTradeRegisterDate=" + entryTradeRegisterDate +
                ", seller=" + seller +
                '}';
    }
}
