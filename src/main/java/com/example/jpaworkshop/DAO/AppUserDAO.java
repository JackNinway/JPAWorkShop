package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Appuser;

import java.util.Collection;

public interface AppUserDAO {
    Appuser findById(int id);
    Collection<Appuser> findAll();
    Appuser create(Appuser appuser);
    Appuser update(Appuser appuser);
    void delete(int id);

}
