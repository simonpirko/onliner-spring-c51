package org.onliner.spring.c51.service;

import org.onliner.spring.c51.dao.ManufacturerDAO;
import org.onliner.spring.c51.entity.Manufacturer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManufacturerService {

    private ManufacturerDAO manufacturerDAO;

    public ManufacturerService(ManufacturerDAO manufacturerDAO) {
        this.manufacturerDAO = manufacturerDAO;
    }

    public List<Manufacturer> getListManufacturers(){
        return manufacturerDAO.findAll();
    }
}
