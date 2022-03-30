package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.MappedSuperclass;

@Data                                                   // ONL-12 : lombok
@NoArgsConstructor                                      // ONL-12 : lombok
@AllArgsConstructor                                     // ONL-12 : lombok
@EqualsAndHashCode(onlyExplicitlyIncluded = true)       // ONL-12 : lombok
@Builder                                                // ONL-12 : lombok
@MappedSuperclass
public abstract class Product {

    @EqualsAndHashCode.Include                          // ONL-12 : lombok
    private String name;
    private int price;
    private String seller;

}
