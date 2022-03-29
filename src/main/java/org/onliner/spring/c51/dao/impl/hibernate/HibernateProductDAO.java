package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.ProductDAO;
import org.onliner.spring.c51.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.Optional;

@Repository
@Transactional
public class HibernateProductDAO implements ProductDAO {

    private final SessionFactory sessionFactory;

    public HibernateProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public boolean exists(Product product) {
        Session session = sessionFactory.openSession();
        Query<Product> findByName = session.createQuery("SELECT pr FROM "+product.getClass().getSimpleName()+" pr WHERE pr.name = :name", Product.class);
        findByName.setParameter("name", product.getName());
        Optional<Product> productdb = findByName.uniqueResultOptional();
        session.close();
        return productdb.isPresent();
    }

    @Override
    public boolean save(Product product) {
        Session session = sessionFactory.openSession();
        Serializable resultId = session.save(product);
        session.close();
        return resultId != null;

    }

    @Override
    public Optional<Product> findByName(String name,String className) {
        Session session = sessionFactory.openSession();
        Query<Product> findByName = session.createQuery("SELECT pr FROM "+className+" pr WHERE pr.name = :name", Product.class);
        findByName.setParameter("name", name);
        Optional<Product> product = findByName.uniqueResultOptional();
        session.close();
        return product;
    }
}
