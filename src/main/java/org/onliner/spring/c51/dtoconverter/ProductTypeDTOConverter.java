package org.onliner.spring.c51.dtoconverter;


import org.onliner.spring.c51.dto.productType.ProductTypeDetailsDTO;
import org.onliner.spring.c51.entity.PairPropertyValue;
import org.onliner.spring.c51.entity.ProductType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductTypeDTOConverter {

    public static ProductTypeDetailsDTO convertToProductTypeDetailsDTOFromProductType(ProductType productType) {
        return ProductTypeDetailsDTO.builder()
                .productTypeId(productType.getId())
                .productTypeName(productType.getName())
                .productDescription(getProductDescription(productType))
                .build();
    }

    private static Map<String, Map<String, List<String>>> getProductDescription(ProductType productType) {
        return productType.getPairPropertyValueListForType().stream().distinct()
                .collect(Collectors.groupingBy(productPropertyGroup->productPropertyGroup.getProductPropertyGroup().getName(),
                        Collectors.groupingBy(productProperty->productProperty.getProductProperty().getName(),
                                Collectors.mapping(PairPropertyValue::getValue,
                                        Collectors.toList()))));





    }
}
