package com.example.form_register.service;

import com.example.form_register.model.User;
import com.example.form_register.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean add(User user1) {
        User user = userRepository.save(user1);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public User getUser(int id) {

        return userRepository.findById(id).get();
    }
}
