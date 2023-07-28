package com.example.borrow_books.model;

import javax.persistence.*;
//user là mã mượn sách nha thầy
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int code;
    @ManyToOne
    @JoinColumn(name="book_id",referencedColumnName = "id")
    private Book book;

    public User(int id, int code) {
        this.id = id;
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User(Book book) {
        this.book = book;
    }

    public User(int id, int code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    @PreUpdate
    public void preUpdate(){
        int max = 99999;
        int min = 10000;
        this.code=(int) ((Math.random() * (max - min)) + min);
    }
    @PrePersist
    public void prePersist(){
        int max = 99999;
        int min = 10000;
        this.code=(int) ((Math.random() * (max - min)) + min);
    }
}
