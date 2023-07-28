package com.example.borrow_books.service.book;

import com.example.borrow_books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book getById(int id);

    void update(Book book);
}
