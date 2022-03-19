package org.onliner.spring.c51.dao;

public interface GenericEntityDAO<T> {

    boolean save(T entity);
}
