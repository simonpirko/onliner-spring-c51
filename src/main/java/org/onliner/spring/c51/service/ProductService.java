package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.ProductDAO;
import org.onliner.spring.c51.dto.product.ProductCatalogDTO;
import org.onliner.spring.c51.dto.product.ProductDetailsDTO;
import org.onliner.spring.c51.dtoconverter.ProductDTOConverter;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.ProductType;
import org.onliner.spring.c51.enums.ProductTypes;
import org.onliner.spring.c51.exception.BusinessEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private final ProductDAO productDAO;
    private final ProductTypeService productTypeService;

    public ProductService(ProductDAO productDAO, ProductTypeService productTypeService) {
        this.productDAO = productDAO;
        this.productTypeService = productTypeService;
    }

    public boolean exists(Product product){
        return productDAO.exists(product);
    }

    public boolean save(Product product){
        return productDAO.save(product);
    }

    public List<ProductCatalogDTO> findAllByProductType(ProductTypes productTypes) {
        Optional<ProductType> foundProductType =
                productTypeService.findByProductTypeName(productTypes.name());
        if (foundProductType.isPresent()) {
            List<Product> allByProductType = productDAO.findAllByProductType(foundProductType.get());
            return allByProductType.stream()
                    .map(ProductDTOConverter::convertToProductCatalogDTOFromProduct)
                    .collect(Collectors.toList());
        } else {
            throw new BusinessEntityNotFoundException("No product type with this name!");
        }
    }

    public ProductDetailsDTO getProductDetailsByProductId(long id) {
        Optional<Product> foundProduct = productDAO.findById(id);
        if (foundProduct.isPresent()) {
            return ProductDTOConverter.convertToProductDetailsDTOFromProduct(foundProduct.get());
        } else {
            throw new BusinessEntityNotFoundException("No product with this ID");
        }
    }
}