package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();
    Category getCategoryById(int categoryId);

    void add(Category category);

    void delete(int id);

//    void update(Category category);
}
