package org.onliner.spring.c51.dao;

public interface GenericEntityDAO<T> {

    boolean exists(T entity);

    boolean save(T entity);
}
