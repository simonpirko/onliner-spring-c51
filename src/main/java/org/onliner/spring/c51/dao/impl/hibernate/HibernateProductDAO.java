package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.ProductDAO;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.User;
import org.onliner.spring.c51.entity.phone.Smartphone;
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
        return false;
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
        Query<Product> findByName = session.createQuery("SELECT u FROM "+className+" u WHERE u.name = :name", Product.class);
        findByName.setParameter("name", name);
        Optional<Product> product = findByName.uniqueResultOptional();
        session.close();
        return product;
    }
}
