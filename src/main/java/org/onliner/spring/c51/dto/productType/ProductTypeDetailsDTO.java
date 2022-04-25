package org.onliner.spring.c51.dto.productType;

import lombok.*;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ProductTypeDetailsDTO {
    private long productTypeId;
    private String productTypeName;
    private Map<String, Map<String, List<String>>> productDescription;
}
