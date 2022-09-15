package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Book;
import com.example.jpaworkshop.Entity.BookLoan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class BookLoanDAOImpl implements BookLoanDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Transactional
    @Override
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Transactional
    @Override
    public Collection<BookLoan> findAll() {
        TypedQuery<BookLoan> foundAll = entityManager.createQuery("select bl from BookLoan bl", BookLoan.class);
        Collection<BookLoan> resBookLoan= foundAll.getResultList();
        return resBookLoan;
    }

    @Transactional
    @Override
    public BookLoan update(BookLoan bookLoan) {
        entityManager.merge(bookLoan);
        return bookLoan;
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
