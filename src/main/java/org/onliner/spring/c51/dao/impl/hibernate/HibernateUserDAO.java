package org.onliner.spring.c51.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.onliner.spring.c51.dao.UserDAO;
import org.onliner.spring.c51.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Repository
@Transactional
public class HibernateUserDAO implements UserDAO {
    private final SessionFactory sessionFactory;

    public HibernateUserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean save(User user) {
        Session session = sessionFactory.openSession();
        Serializable resultId = session.save(user);
        session.close();
        return resultId != null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Session session = sessionFactory.openSession();
        Query<User> findByEmail = session.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        findByEmail.setParameter("email", email);
        Optional<User> user = findByEmail.uniqueResultOptional();
        session.close();
        return user;
    }
}
