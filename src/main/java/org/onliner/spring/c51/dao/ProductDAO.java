package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.User;
import org.onliner.spring.c51.entity.phone.Smartphone;

import java.util.Optional;

public interface ProductDAO extends GenericEntityDAO<Product>{

    Optional<Product> findByName(String name, String className);

}
