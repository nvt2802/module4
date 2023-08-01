package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;



    @Override
    public Page<Blog> getAll(Pageable pageable,String name) {
        return blogRepository.findBlogByTitleContaining(pageable,name);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
//        if(blog==null){
//            return false;
//        }

    }

    @Override
    public Blog getById(int id) {
       return blogRepository.findById(id).orElse(null);
    }



    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }



    @Override
    public void add(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> getByCategory(Pageable pageable, int categoryId) {
        return blogRepository.findBlogsByCategory_Id(pageable,categoryId);
    }

    @Override
    public List<Blog> getAllist() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> getListBlogByCategotyId(int id) {
        return blogRepository.findBlogsByCategory_Id(id);
    }
}
