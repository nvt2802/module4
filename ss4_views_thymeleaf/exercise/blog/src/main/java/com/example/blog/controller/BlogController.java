package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @RequestMapping("")
    public String showBlog(Model model){
        List<Blog> blogs = blogService.getAll();
        model.addAttribute("blogs",blogs);
        return "list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
      blogService.delete(id);
        redirectAttributes.addFlashAttribute("msg","Xoa thanh cong");
        return "redirect:/blog";
    }
    @RequestMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id,Model model){
       Blog blog = blogService.getById(id);
        List<Category> categories = blogService.getAllCategory();
        model.addAttribute("blog",blog);
        model.addAttribute("categories",categories);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,@RequestParam int categoryId, RedirectAttributes redirectAttributes){
        Category category = blogService.getCategoryById(categoryId);
        blog.setCategory(category);
        blogService.update(blog);
        return "redirect:/blog";
    }
    @RequestMapping("/create")
    private String showFormCreate(Model model){
        Blog blog = new Blog();
        List<Category> categories = blogService.getAllCategory();
        model.addAttribute("categories",categories);
        model.addAttribute("blog",blog);
        return "create";
    }
    @PostMapping("/create")
    private String create(@ModelAttribute Blog blog,@RequestParam int categoryId,RedirectAttributes redirectAttributes){
        Category category = blogService.getCategoryById(categoryId);
        blog.setCategory(category);
        blogService.add(blog);
        return "redirect:/blog";
    }
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model){
        Blog blog = blogService.getById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
}
