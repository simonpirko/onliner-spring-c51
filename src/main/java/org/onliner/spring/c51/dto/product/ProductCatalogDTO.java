package org.onliner.spring.c51.dto.product;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ProductCatalogDTO {
    private long id;
    private String name;
    private String manufacturerName;
    private int sellerOffersNumber;
}
