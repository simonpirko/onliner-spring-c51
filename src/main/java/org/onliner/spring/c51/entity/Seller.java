package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Seller.exists", query = "SELECT s FROM Seller s " +
                "WHERE s.stateRegistrationInformation.payerAccountNumber = :UNP"),
        @NamedQuery(name = "Seller.findAll",
                query = "SELECT s FROM Seller s"),
        @NamedQuery(name = "Seller.findBySellerManagerId",
                query = "SELECT s FROM Seller s JOIN FETCH s.managers m LEFT JOIN FETCH s.sellerOffers WHERE m.id = :sellerManagerId")
})

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Include
    private StateRegistrationInformation stateRegistrationInformation;

    private boolean verifiedSeller;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.MERGE)
    private Set<SellerOffer> sellerOffers = new HashSet<>();

    @OneToMany
    private Set<User> managers = new HashSet<>();


    public void addSellerOffer(SellerOffer sellerOffer) {
        sellerOffers.add(sellerOffer);
        sellerOffer.setSeller(this);
    }

    public void removeSellerOffer(SellerOffer sellerOffer) {
        sellerOffers.remove(sellerOffer);
        sellerOffer.setSeller(null);
    }
}
