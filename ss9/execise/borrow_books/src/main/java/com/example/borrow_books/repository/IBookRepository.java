package com.example.borrow_books.repository;

import com.example.borrow_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
