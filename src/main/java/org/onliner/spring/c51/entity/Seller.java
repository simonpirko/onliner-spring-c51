package org.onliner.spring.c51.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "Seller.exists", query = "SELECT s FROM Seller s " +
                "WHERE s.stateRegistrationInformation.payerAccountNumber = :UNP"),
        @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s")
})
@Entity
@Table
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime creationDateTime = LocalDateTime.now();
    private LocalDateTime updateDateTime = LocalDateTime.now();
    @OneToOne(cascade = CascadeType.ALL)
    private StateRegistrationInformation stateRegistrationInformation;
    private boolean verifiedSeller;

    public Seller() {
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

    public StateRegistrationInformation getStateRegistrationInformation() {
        return stateRegistrationInformation;
    }

    public void setStateRegistrationInformation(StateRegistrationInformation stateRegistrationInformation) {
        this.stateRegistrationInformation = stateRegistrationInformation;
    }

    public boolean isVerifiedSeller() {
        return verifiedSeller;
    }

    public void setVerifiedSeller(boolean verifiedSeller) {
        this.verifiedSeller = verifiedSeller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(stateRegistrationInformation, seller.stateRegistrationInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateRegistrationInformation);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", creationDateTime=" + creationDateTime +
                ", updateDateTime=" + updateDateTime +
                ", stateRegistrationInformation=" + stateRegistrationInformation +
                ", verifiedSeller=" + verifiedSeller +
                '}';
    }
}
