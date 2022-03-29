package org.onliner.spring.c51.dao;

import java.util.List;

public interface GenericEntityDAO<T> {

    boolean exists(T entity);

    boolean save(T entity);

    List<T> findAll();
}
