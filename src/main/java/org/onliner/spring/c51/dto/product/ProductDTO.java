package org.onliner.spring.c51.dto.product;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ProductDTO {

    private String name;
    private long manufacturerId;
    private long productTypeId;
    private List<Long> propertiesList;

}
