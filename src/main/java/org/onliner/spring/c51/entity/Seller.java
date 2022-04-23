package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "Seller.exists", query = "SELECT s FROM Seller s " +
                "WHERE s.stateRegistrationInformation.payerAccountNumber = :UNP"),
        @NamedQuery(name = "Seller.findByP", query = "SELECT s FROM Seller s " +
                "WHERE s.stateRegistrationInformation.payerAccountNumber = :UNP"),
        @NamedQuery(name = "Seller.findById", query = "SELECT s FROM Seller s WHERE s.id = :id"),
        @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime creationDateTime = LocalDateTime.now();
    private LocalDateTime updateDateTime = LocalDateTime.now();
    @OneToOne(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include                      // ONL-12 : lombok
    private StateRegistrationInformation stateRegistrationInformation;
    private boolean verifiedSeller;
}
