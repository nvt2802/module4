package com.example.borrow_books.repository;

import com.example.borrow_books.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    void deleteByCode(int code);
    User findUserByCode(int code);
}
