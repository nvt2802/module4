package com.example.borrow_books.service.user;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.User;

public interface IUserService {

    int add(User user);

    boolean deleteByCode(int code);

    User getByCode(int bookCode);
}
