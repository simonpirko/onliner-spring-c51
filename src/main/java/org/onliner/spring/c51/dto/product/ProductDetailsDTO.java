package org.onliner.spring.c51.dto.product;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ProductDetailsDTO {
    private long productId;
    private String productName;
    private String manufacturerDetails;
    private Map<String, Map<String, String>> productDescription;
}
