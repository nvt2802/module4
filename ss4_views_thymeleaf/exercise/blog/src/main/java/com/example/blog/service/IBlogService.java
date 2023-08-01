package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAll(Pageable pageable,String name);

    void delete(int id);

    Blog getById(int id);



    void update(Blog blog);


    void add(Blog blog);

    Page<Blog> getByCategory(Pageable pageable, int categoryId);

    List<Blog> getAllist();

    List<Blog> getListBlogByCategotyId(int id);
}
