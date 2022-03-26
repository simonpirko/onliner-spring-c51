package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.ProductDAO;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.User;
import org.onliner.spring.c51.entity.phone.Smartphone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductDAO productDAO;
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);


    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public boolean save(Product product){
        System.out.println(product.getClass().getName());
        if (productDAO.findByName(product.getName(), product.getClass().getName()).isPresent()) {
            logger.info(this.getClass().getName() + " SIGNUP METHOD " + "Product with name " + product.getName() + " already exists!");
            return false;
        } else {

            return productDAO.save(product);
        }


    }
}