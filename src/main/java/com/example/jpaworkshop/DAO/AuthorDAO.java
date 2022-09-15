package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Appuser;
import com.example.jpaworkshop.Entity.Author;

import java.util.Collection;

public interface AuthorDAO {
    Author findById(int id);
    Collection<Author> findAll();
    Author create(Author author);
    Author update(Author author);
    void delete(int id);
}
