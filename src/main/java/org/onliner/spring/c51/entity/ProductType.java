package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "ProductType.exists", query = "SELECT pt FROM ProductType pt WHERE pt.name = :name"),
        @NamedQuery(name = "ProductType.findAll", query = "SELECT pt FROM ProductType pt"),
        @NamedQuery(name = "ProductType.findAllJoinProductSubcategoryJoinProductCategory",
                query = "SELECT pt FROM ProductType pt JOIN FETCH pt.productSubcategory psc JOIN FETCH psc.productCategory"),
        @NamedQuery(name = "ProductType.findByProductTypeName",
                query = "SELECT pt FROM ProductType pt JOIN FETCH pt.pairPropertyValueListForType WHERE pt.name = :name")
})

@Entity
@Table(name = "product_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "product_subcategory_id")
    private ProductSubcategory productSubcategory;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "products_type_pairs_product_property_value",
            joinColumns = @JoinColumn(name="product_type_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="pair_attribute_value_id", referencedColumnName="id")
    )
    private List<PairPropertyValue> pairPropertyValueListForType = new ArrayList<>();
}
