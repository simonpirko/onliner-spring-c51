package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.SellerDAO;
import org.onliner.spring.c51.entity.Seller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
        Query<Seller> exists = session.createQuery("SELECT s FROM Seller s " +
                "WHERE s.stateRegistrationInformation.payerAccountNumber = :UNP", Seller.class);
        exists.setParameter("UNP", seller.getStateRegistrationInformation().getPayerAccountNumber());
        Optional<Seller> user = exists.uniqueResultOptional();
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
}
