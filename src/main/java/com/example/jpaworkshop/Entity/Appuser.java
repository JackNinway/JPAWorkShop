package com.example.jpaworkshop.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Appuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
    private LocalDate regDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Details userDetails;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
               mappedBy = "borrower")
    private List<BookLoan> loans;

    public Appuser() {
    }

    public Appuser(String username, String password, LocalDate regDate, Details userDetails) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }
    public void addBookLoan(BookLoan bookLoan){
        if(!loans.contains(bookLoan)) {
            loans.add(bookLoan);
            bookLoan.setBorrower(this);
        }
    }
    public void removeBookLoan(BookLoan bookLoan){
        if(loans.contains(bookLoan)) {
            bookLoan.setBorrower(null);
            loans.remove(bookLoan);
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appuser appuser = (Appuser) o;
        return id == appuser.id && Objects.equals(username, appuser.username) && Objects.equals(password, appuser.password) && Objects.equals(regDate, appuser.regDate) && Objects.equals(userDetails, appuser.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, regDate, userDetails);
    }

    @Override
    public String toString() {
        return "Appuser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                '}';
    }
}
