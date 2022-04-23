package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "Seller.exists", query = "SELECT s FROM Seller s " +
                "WHERE s.stateRegistrationInformation.payerAccountNumber = :UNP"),
        @NamedQuery(name = "Seller.findAll",
                query = "SELECT s FROM Seller s"),
        @NamedQuery(name = "Seller.findBySellerManagerId",
                query = "SELECT s FROM Seller s JOIN FETCH s.managers m LEFT JOIN FETCH s.sellerOffers WHERE m.id = :sellerManagerId")
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
