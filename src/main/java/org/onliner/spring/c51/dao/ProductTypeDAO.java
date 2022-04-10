package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeDAO extends GenericEntityDAO<ProductType> {

    List<ProductType> getCatalog();

    Optional<ProductType> findByProductTypeName(String name);
}
