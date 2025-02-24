package com.souza.charles.graphicalapp.model.services;
 /*
  Course title: Complete Java - Object-Oriented Programming + Projects
  Instructor: Prof. Dr. Nelio Alves - Udemy, Inc.
  Project done by: Charles Fernandes de Souza
  Date: February 23, 2025
 */

import com.souza.charles.graphicalapp.model.dao.DaoFactory;
import com.souza.charles.graphicalapp.model.dao.SellerDao;
import com.souza.charles.graphicalapp.model.entities.Seller;

import java.util.List;

public class SellerService {

    private SellerDao dao = DaoFactory.createSellerDao();

    public List<Seller> findAll() {
        return dao.findAll();
    }

    public void saveOrUpdate(Seller obj) {
        if (obj.getId() == null) {
            dao.insert(obj);
        } else {
            dao.update(obj);
        }
    }

    public void remove(Seller obj) {
        dao.deleteById(obj.getId());
    }
}