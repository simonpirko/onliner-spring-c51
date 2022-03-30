package org.onliner.spring.c51.service;

import com.google.protobuf.MapEntry;
import org.onliner.spring.c51.dao.ProductDAO;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.enums.ProductCategory;
import org.onliner.spring.c51.enums.ProductSubcategory;
import org.onliner.spring.c51.enums.ProductType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductDAO productDAO;
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public boolean exists(Product product){
        return productDAO.exists(product);
    }

    public boolean save(Product product){

        if (productDAO.findByName(product.getName(), product.getClass().getSimpleName()).isPresent()) {
            logger.info(this.getClass().getName() + " CREATE PRODUCT METHOD " + "Product with name " + product.getName() + " already exists!");
            return false;
        } else {

            return productDAO.save(product);
        }
    }

    public Map<ProductCategory, Map<ProductSubcategory, List<ProductType>>> getCatalog() {
        return Arrays.stream(ProductType.values())
                .collect(Collectors.groupingBy(ProductType::getProductSubcategory))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().getProductCategory(),
                        Collectors.mapping(Function.identity(), Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue ))));
    }

    public List<Product> findAllByProductType(ProductType productType) {
        return productDAO.findAllByTableName(productType.getName());
    }
}