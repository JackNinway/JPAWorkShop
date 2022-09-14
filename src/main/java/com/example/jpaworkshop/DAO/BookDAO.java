package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Appuser;
import com.example.jpaworkshop.Entity.Book;

import java.util.Collection;

public interface BookDAO {
    Book findById(int id);
    Book create(Book book);
    Collection<Book> findAll();
    Book update(Book book);
    void delete(int id);

}
