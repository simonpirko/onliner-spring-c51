package org.onliner.spring.c51.dtoconverter;

import org.onliner.spring.c51.dto.product.ProductCatalogDTO;
import org.onliner.spring.c51.dto.product.ProductDetailsDTO;
import org.onliner.spring.c51.entity.PairPropertyValue;
import org.onliner.spring.c51.entity.Product;

import java.util.Map;
import java.util.stream.Collectors;

public class ProductDTOConverter {

    public static ProductCatalogDTO convertToProductCatalogDTOFromProduct(Product product) {
        return ProductCatalogDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .manufacturerName(product.getManufacturer().getName())
                .sellerOffersNumber(product.getSellerOffers().size())
                .build();
    }

    public static ProductDetailsDTO convertToProductDetailsDTOFromProduct(Product product) {
        return ProductDetailsDTO.builder()
                .productId(product.getId())
                .productName(product.getName())
                .manufacturerDetails(product.getManufacturer().getName())
                .productDescription(getProductDescription(product))
                .build();
    }

    private static Map<String, Map<String, String>> getProductDescription(Product product) {
        return product.getPairPropertyValueList().stream()
                .collect(Collectors.groupingBy(PairPropertyValue::getProductPropertyGroup))
                .entrySet().stream()
                .collect(Collectors.toMap(entrySet -> entrySet.getKey().getName(),
                        entrySet -> entrySet.getValue().stream()
                                .collect(Collectors.toMap(pair -> pair.getProductProperty().getName(), PairPropertyValue::getValue))));
     }
}
