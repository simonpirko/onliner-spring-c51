package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.SellerFeedbackDAO;
import org.onliner.spring.c51.entity.Seller;
import org.onliner.spring.c51.entity.SellerFeedback;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateSellerFeedbackDAO implements SellerFeedbackDAO{

    private final SessionFactory sessionFactory;

    public HibernateSellerFeedbackDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean exists(SellerFeedback sellerFeedback) {
        Session session = sessionFactory.openSession();
        Query<SellerFeedback> namedQuery = session.createNamedQuery("SellerFeedback.exists", SellerFeedback.class);
        namedQuery.setParameter("id", sellerFeedback.getId());
        Optional<SellerFeedback> foundSellerFeedback = namedQuery.uniqueResultOptional();
        session.close();
        return foundSellerFeedback.isPresent();
    }

    @Override
    public boolean save(SellerFeedback sellerFeedback) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(sellerFeedback);
        return true;
    }

    @Override
    public List<SellerFeedback> findBySeller(Seller seller) {
        Session session = sessionFactory.openSession();
        Query<SellerFeedback> namedQuery = session.createNamedQuery("SellerFeedback.findBySeller", SellerFeedback.class);
        namedQuery.setParameter("seller", seller);
        List<SellerFeedback> sellerFeedbacks = namedQuery.list();
        session.close();
        return sellerFeedbacks;
    }

    @Override
    public List<SellerFeedback> findAll() {
        Session session = sessionFactory.openSession();
        Query<SellerFeedback> namedQuery = session.createNamedQuery("SellerFeedback.findAll", SellerFeedback.class);
        List<SellerFeedback> sellerFeedbacks = namedQuery.list();
        session.close();
        return sellerFeedbacks;
    }
}
