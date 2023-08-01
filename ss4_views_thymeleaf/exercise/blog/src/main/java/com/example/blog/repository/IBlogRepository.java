package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findBlogByTitleContaining(Pageable pageable,String name);
    Page<Blog> findBlogsByCategory_Id(Pageable pageable,int id);
    List<Blog> findBlogsByCategory_Id(int id);
}
