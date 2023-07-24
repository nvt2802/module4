package com.example.controller;

import com.example.model.Products;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes) {
       boolean check= productService.delete(id);
       if(check) {
           redirectAttributes.addFlashAttribute("msg", "Delete successful");
       }else {
           redirectAttributes.addFlashAttribute("msg", "Delete doesn't successful");
       }
        return "redirect:/product/list";
    }
    @RequestMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model){
        Products product = productService.getById(id);
        model.addAttribute("product",product);
        return "update";
    }
    @RequestMapping("detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        Products product = productService.getById(id);
        model.addAttribute("product",product);
        return "detail";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Products product,RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("msg","Update successful");
        return "redirect:/product/list";
    }
    @RequestMapping("/create")
    public String showFormCreate(Model model){
        Products product = new Products();
        model.addAttribute("product",product);
        return "create";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Products product,RedirectAttributes redirectAttributes){
        productService.create(product);
        redirectAttributes.addFlashAttribute("msg","Add successful");
        return "redirect:/product/list";
    }
    @RequestMapping("/search")
    public String search(@RequestParam String name,Model model){
        System.out.println(name);
        List<Products> productsList = productService.search(name);
        if(productsList.isEmpty()){
            model.addAttribute("msg","Can't find any product");
        }else {
            model.addAttribute("products",productsList);
        }
        return "list";
    }
}
