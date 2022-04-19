package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
//:productId :sellerManagerId
@NamedQueries({
        @NamedQuery(name = "SellerOffer.findAll",
                query = "SELECT so FROM SellerOffer so"),
        @NamedQuery(name = "SellerOffer.findByProductId",
                query = "SELECT so FROM SellerOffer so WHERE so.product.id = :productId"),
        @NamedQuery(name = "SellerOffer.existsByProductIdAndSellerManagerId",
                query = "SELECT so FROM SellerOffer so JOIN so.product p JOIN so.seller s JOIN s.managers m WHERE p.id = :productId AND m.id = :sellerManagerId")
})

@Entity
@Table(name = "seller_offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class SellerOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @ManyToOne
    private Seller seller;

    @ManyToOne
    private Product product;

    private double price;
}
