package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Appuser;
import com.example.jpaworkshop.Entity.Details;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

public class AppUserDAOImpl implements AppUserDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Appuser findById(int id) {
        return entityManager.find(Appuser.class, id);
    }
    @Transactional
    @Override
    public Collection<Appuser> findAll() {
        TypedQuery<Appuser> foundAll = entityManager.createQuery("select a from Appuser a", Appuser.class);
        Collection<Appuser> resAppuser = foundAll.getResultList();
        return resAppuser;
    }

    @Override
    public Appuser create(Appuser appuser) {
        entityManager.persist(appuser);
        return appuser;
    }

    @Override
    public Appuser update(Appuser appuser) {
        return entityManager.merge(appuser);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
