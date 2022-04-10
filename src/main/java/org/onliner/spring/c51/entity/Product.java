package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Product.exists", query = "SELECT p FROM Product p WHERE p.name = :name"),
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findAllByProductType", query = "SELECT p FROM Product p WHERE p.productType = :productType"),
        @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p JOIN FETCH p.manufacturer JOIN FETCH p.pairPropertyValueList WHERE p.id = :id")
})

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "products_pairs_attribute_value",
            joinColumns = @JoinColumn(name="product_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="pair_attribute_value_id", referencedColumnName="id")
    )
    private List<PairPropertyValue> pairPropertyValueList = new ArrayList<>();
}
