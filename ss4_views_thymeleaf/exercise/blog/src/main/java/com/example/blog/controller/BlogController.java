package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView showBlog(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "") String searchName){
        Pageable pageable = PageRequest.of(page,2,Sort.by("date").descending());
        Page<Blog> blogs = blogService.getAll(pageable,searchName);
        List<Category> categories = categoryService.getAllCategory();
//        List<Blog> blogs = blogService.getAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs",blogs);
        modelAndView.addObject("searchName",searchName);
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
      blogService.delete(id);
        redirectAttributes.addFlashAttribute("msg","Xoa thanh cong");
        return "redirect:/blog/list";
    }
    @RequestMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id,Model model){
       Blog blog = blogService.getById(id);
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("blog",blog);
        model.addAttribute("categories",categories);
        return "update";
    }
    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes){
        blogService.update(blog);
        return "redirect:/blog/list";
    }
    @RequestMapping("/create")
    private String showFormCreate(Model model){
        Blog blog = new Blog();
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories",categories);
        model.addAttribute("blog",blog);
        return "create";
    }
    @PostMapping("/create")
    private String create( Blog blog,RedirectAttributes redirectAttributes){
//        Category category = categoryService.getCategoryById(categoryId);
//        blog.setCategory(category);
        blogService.add(blog);
        return "redirect:/blog/list";
    }
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model){
        Blog blog = blogService.getById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
    @RequestMapping("/category")
    public String showCategory(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories",categories);
        return "category";
    }
    @RequestMapping("/createCategory")
    public String showFormCreateCategory(Model model){
        Category category = new Category();
        model.addAttribute(category);
        return "careateCategory";
    }
    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute Category category,RedirectAttributes redirectAttributes){
        categoryService.add(category);
        redirectAttributes.addFlashAttribute("msg","Thêm thành công");
        return "redirect:/blog/category";
    }
    @RequestMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id,RedirectAttributes redirectAttributes){
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("msg","Xoá thành công");
        return "redirect:/blog/category";
    }
    @RequestMapping("/updateCategory/{id}")
    public String showUpdateCategory(@PathVariable int id,Model model){
        Category category =categoryService.getCategoryById(id);
       model.addAttribute("category",category);
        return "updateCategory";
    }
    @PostMapping("/updateCategory")
    public String updateCategory(Category category,RedirectAttributes redirectAttributes){
        categoryService.add(category);
        redirectAttributes.addFlashAttribute("msg","Sửa thành công");
        return "redirect:/blog/category";
    }
    @RequestMapping("/categoryList")
    public ModelAndView categoryList(@RequestParam(defaultValue = "0") int page,
                               @RequestParam int categoryId){
        Pageable pageable = PageRequest.of(page,2,Sort.by("date").descending());
        Page<Blog> blogs = blogService.getByCategory(pageable,categoryId);
        List<Category> categories = categoryService.getAllCategory();
//        List<Blog> blogs = blogService.getAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs",blogs);
        modelAndView.addObject("categories",categories);
        return modelAndView;

    }
}
