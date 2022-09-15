package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
@Repository
public class AuthorDAOImpl implements AuthorDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("select a FROM Author a", Author.class).getResultList();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
