package com.example.jpaworkshop.Entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;
    @ManyToOne
    private Appuser borrower;
    @ManyToOne
    private Book book;

}
