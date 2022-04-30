package org.onliner.spring.c51.dao;

import org.onliner.spring.c51.entity.Manufacturer;

import java.util.Optional;

public interface ManufacturerDAO extends GenericEntityDAO<Manufacturer>{
    public Optional<Manufacturer> findById(long id);
}
