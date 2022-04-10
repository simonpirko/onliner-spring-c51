package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "SellerFeedback.exists", query = "SELECT sf FROM SellerFeedback sf WHERE sf.id = :id"),
        @NamedQuery(name = "SellerFeedback.findBySeller", query = "SELECT sf FROM SellerFeedback sf WHERE sf.seller = :seller"),
        @NamedQuery(name = "SellerFeedback.findAll", query = "SELECT sf FROM SellerFeedback sf")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table
public class SellerFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String title;
    private String description;
    private String grade;

    @ManyToOne(targetEntity = User.class)
    private User user = new User();
    @ManyToOne(targetEntity = Seller.class)
    private Seller seller = new Seller();
}