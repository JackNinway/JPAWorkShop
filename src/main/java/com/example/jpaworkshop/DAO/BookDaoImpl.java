package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Appuser;
import com.example.jpaworkshop.Entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class BookDaoImpl implements BookDAO{
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public Book findById(int id) {
        return entityManager.find(Book.class,id);
    }
    @Transactional
    @Override
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }
    @Transactional
    @Override
    public Collection<Book> findAll() {
        TypedQuery<Book> foundAll = entityManager.createQuery("select b from Book b", Book.class);
        Collection<Book> resBook= foundAll.getResultList();
        return resBook;
    }
    @Transactional
    @Override
    public Book update(Book book) {
        entityManager.merge(book);
        return book;
    }
    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
