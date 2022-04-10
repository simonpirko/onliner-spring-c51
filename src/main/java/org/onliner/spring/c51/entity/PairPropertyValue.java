package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pair_property_value")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class PairPropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_property_group_id")
    private ProductPropertyGroup productPropertyGroup;

    @ManyToOne
    @JoinColumn(name = "product_property_id")
    private ProductProperty productProperty;

    private String value;

    @ManyToMany(mappedBy = "pairPropertyValueList")
    private Set<Product> products = new HashSet<>();
}
