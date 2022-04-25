package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.ProductTypeDAO;
import org.onliner.spring.c51.dto.productType.ProductTypeDetailsDTO;
import org.onliner.spring.c51.dtoconverter.ProductTypeDTOConverter;
import org.onliner.spring.c51.entity.ProductCategory;
import org.onliner.spring.c51.entity.ProductSubcategory;
import org.onliner.spring.c51.entity.ProductType;
import org.onliner.spring.c51.exception.BusinessEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductTypeService {
    private ProductTypeDAO productTypeDAO;

    public ProductTypeService(ProductTypeDAO productTypeDAO) {
        this.productTypeDAO = productTypeDAO;
    }

    public Map<ProductCategory, Map<ProductSubcategory, List<ProductType>>> getCatalog() {
        return productTypeDAO.getCatalog().stream()
                .collect(Collectors.groupingBy(ProductType::getProductSubcategory))
                .entrySet().stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().getProductCategory(),
                        Collectors.mapping(Function.identity(), Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue))));
    }

    public Optional<ProductType> findByProductTypeName(String name) {
        return productTypeDAO.findByProductTypeName(name);
    }

    public ProductTypeDetailsDTO getProductTypeDetailsDTO(Optional<ProductType> productType){
        if(productType.isPresent()){
            return ProductTypeDTOConverter.convertToProductTypeDetailsDTOFromProductType(productType.get());
        }
        else throw new BusinessEntityNotFoundException("This type is not available");
    }
}
