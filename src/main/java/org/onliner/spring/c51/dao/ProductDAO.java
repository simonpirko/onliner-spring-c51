package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Product;
import java.util.Optional;

public interface ProductDAO extends GenericEntityDAO<Product>{

    Optional<Product> findByName(String name, String className);

}
