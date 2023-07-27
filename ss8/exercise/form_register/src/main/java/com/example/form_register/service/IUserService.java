package com.example.form_register.service;

import com.example.form_register.model.User;

public interface IUserService {
    boolean add(User user1);

    User getUser(int id);

}
