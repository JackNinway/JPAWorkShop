package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class DetailsDAOImpl implements DetailsDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Details findById(int id) {
        return entityManager.find(Details.class, id);
    }
    @Transactional
    @Override
    public Collection<Details> findAll() {
        TypedQuery<Details> foundAll = entityManager.createQuery("select d from Details  d", Details.class);
        Collection<Details> resDetails = foundAll.getResultList();
        return resDetails;
    }
    @Transactional
    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }
    @Transactional
    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }
    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
