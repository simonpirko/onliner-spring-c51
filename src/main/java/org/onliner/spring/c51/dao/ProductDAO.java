package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.enums.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductDAO extends GenericEntityDAO<Product>{

    Optional<Product> findByName(String name, String className);

    List<Product> findAllByTableName(String name);
}
