package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.SellerDAO;
import org.onliner.spring.c51.entity.Seller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateSellerDAO implements SellerDAO {
    private final SessionFactory sessionFactory;

    public HibernateSellerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(Seller seller) {
        Session session = sessionFactory.openSession();
        Query<Seller> namedQuery = session.createNamedQuery("Seller.exists", Seller.class);
        namedQuery.setParameter("UNP", seller.getStateRegistrationInformation().getPayerAccountNumber());
        Optional<Seller> user = namedQuery.uniqueResultOptional();
        session.close();
        return user.isPresent();
    }

    @Override
    public boolean save(Seller seller) {
        Session session = sessionFactory.openSession();
        Serializable sellerResultId = session.save(seller);
        session.close();
        return sellerResultId != null;
    }

    @Override
    public List<Seller> findAll() {
        Session session = sessionFactory.openSession();
        Query<Seller> namedQuery = session.createNamedQuery("Seller.findAll", Seller.class);
        List<Seller> users = namedQuery.list();
        session.close();
        return users;
    }


    public Seller findByPayerAccountNumber(int payerAccountNumber) {
        Session session = sessionFactory.openSession();
        Query<Seller> namedQuery = session.createNamedQuery("Seller.exists", Seller.class);
        namedQuery.setParameter("UNP", payerAccountNumber);
        Optional<Seller> user = namedQuery.uniqueResultOptional();
        session.close();
        return user.get();
    }

    @Override
    public Optional<Seller> findById(long id) {
        Session session = sessionFactory.openSession();
        Query<Seller> namedQuery = session.createNamedQuery("Seller.findById", Seller.class);
        namedQuery.setParameter("id", id);
        Optional<Seller> seller = namedQuery.uniqueResultOptional();
        session.close();
        return seller;
    }
}
