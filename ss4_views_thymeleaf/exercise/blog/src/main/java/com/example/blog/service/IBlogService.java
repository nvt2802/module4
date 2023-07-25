package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    void delete(int id);

    Blog getById(int id);

    List<Category> getAllCategory();

    void update(Blog blog);

    Category getCategoryById(int categoryId);

    void add(Blog blog);
}
