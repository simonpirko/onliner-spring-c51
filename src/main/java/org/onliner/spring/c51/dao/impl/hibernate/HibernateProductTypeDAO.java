package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.ProductTypeDAO;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.ProductType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateProductTypeDAO implements ProductTypeDAO {
    private SessionFactory sessionFactory;

    public HibernateProductTypeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(ProductType productType) {
        Session session = sessionFactory.openSession();
        Query<ProductType> namedQuery = session.createNamedQuery("ProductType.exists", ProductType.class);
        namedQuery.setParameter("name", productType.getName());
        Optional<ProductType> foundProductType = namedQuery.getResultStream().findAny();
        session.close();
        return foundProductType.isPresent();
    }

    @Override
    public boolean save(ProductType productType) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(productType);
        return true;
    }

    @Override
    public List<ProductType> findAll() {
        Session session = sessionFactory.openSession();
        Query<ProductType> namedQuery = session.createNamedQuery("ProductType.findAll", ProductType.class);
        List<ProductType> productTypes = namedQuery.list();
        session.close();
        return productTypes;
    }

    @Override
    public Optional<ProductType> findById(long id) {
        Session session = sessionFactory.openSession();
        ProductType productType = session.get(ProductType.class, id);
        session.close();
        return Optional.ofNullable(productType);
    }

    @Override
    public List<ProductType> getCatalog() {
        Session session = sessionFactory.openSession();
        Query<ProductType> namedQuery = session.createNamedQuery("ProductType.findAllJoinProductSubcategoryJoinProductCategory", ProductType.class);
        List<ProductType> catalog = namedQuery.list();
        session.close();
        return catalog;
    }

    @Override
    public Optional<ProductType> findByProductTypeName(String name) {
        Session session = sessionFactory.openSession();
        Query<ProductType> namedQuery = session.createNamedQuery("ProductType.findByProductTypeName", ProductType.class);
        namedQuery.setParameter("name", name);
        Optional<ProductType> productType = namedQuery.uniqueResultOptional();
        session.close();
        return productType;
    }
}
