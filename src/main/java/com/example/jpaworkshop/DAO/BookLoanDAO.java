package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Book;
import com.example.jpaworkshop.Entity.BookLoan;

import java.util.Collection;

public interface BookLoanDAO {
    BookLoan findById(int id);
    BookLoan create(BookLoan bookLoan);
    Collection<BookLoan> findAll();
    BookLoan update(BookLoan bookLoan);
    void delete(int id);

}
