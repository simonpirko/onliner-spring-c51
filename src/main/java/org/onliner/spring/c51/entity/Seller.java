package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "Seller.exists", query = "SELECT s FROM Seller s " +
                "WHERE s.stateRegistrationInformation.payerAccountNumber = :UNP"),
        @NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s")
})
@Data                                               // ONL-12 : lombok
@NoArgsConstructor                                  // ONL-12 : lombok
@AllArgsConstructor                                 // ONL-12 : lombok
@EqualsAndHashCode(onlyExplicitlyIncluded = true)   // ONL-12 : lombok
@Builder                                            // ONL-12 : lombok
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
