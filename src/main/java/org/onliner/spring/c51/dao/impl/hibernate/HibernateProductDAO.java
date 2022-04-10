package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.ProductDAO;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.ProductType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateProductDAO implements ProductDAO {
    private final SessionFactory sessionFactory;

    public HibernateProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(Product product) {
        Session session = sessionFactory.openSession();
        Query<Product> namedQuery = session.createNamedQuery("Product.exists", Product.class);
        namedQuery.setParameter("name", product.getName());
        Optional<Product> foundProduct = namedQuery.getResultStream().findFirst();
        session.close();
        return foundProduct.isPresent();
    }

    @Override
    public boolean save(Product product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(product);
        return true;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        Query<Product> namedQuery = session.createNamedQuery("Product.findAll", Product.class);
        List<Product> products = namedQuery.list();
        session.close();
        return products;
    }

    @Override
    public Optional<Product> findById(long id) {
        Session session = sessionFactory.openSession();
        Query<Product> namedQuery = session.createNamedQuery("Product.findById", Product.class);
        namedQuery.setParameter("id", id);
        Optional<Product> product = namedQuery.uniqueResultOptional();
        session.close();
        return product;
    }

    @Override
    public List<Product> findAllByProductType(ProductType productType) {
        Session session = sessionFactory.openSession();
        Query<Product> namedQuery = session.createNamedQuery("Product.findAllByProductType", Product.class);
        namedQuery.setParameter("productType", productType);
        List<Product> products = namedQuery.list();
        session.close();
        return products;
    }
}
