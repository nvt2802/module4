package com.example.borrow_books.service.book;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
@Autowired
    private IBookRepository bookRepository;


    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }
}
