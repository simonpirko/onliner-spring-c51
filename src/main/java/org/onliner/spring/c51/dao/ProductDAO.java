package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.ProductType;

import java.util.List;

public interface ProductDAO extends GenericEntityDAO<Product>{

    List<Product> findAllByProductType(ProductType productType);
}
