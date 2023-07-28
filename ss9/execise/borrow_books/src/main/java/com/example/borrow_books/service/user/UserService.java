package com.example.borrow_books.service.user;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.User;
import com.example.borrow_books.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;


    @Override
    public int add(User user) {
        userRepository.save(user);
        return user.getCode();
    }

    @Override
    @Transactional
    public boolean deleteByCode(int code) {

        userRepository.deleteByCode(code);
        return true;
    }

    @Override
    public User getByCode(int bookCode) {
        return userRepository.findUserByCode(bookCode);
    }
}
