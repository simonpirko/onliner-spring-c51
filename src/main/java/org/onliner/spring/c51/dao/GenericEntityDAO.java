package org.onliner.spring.c51.dao;

import java.util.List;
import java.util.Optional;

/**
 * add exceptions to save methods
 */
public interface GenericEntityDAO<T> {

    boolean exists(T entity);

    boolean save(T entity);

    List<T> findAll();

    Optional<T> findById(long id);
}
