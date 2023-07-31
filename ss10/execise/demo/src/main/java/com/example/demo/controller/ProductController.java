package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.EmailServiceImpl;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private EmailServiceImpl emailService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @RequestMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("product", productService.findById(id).get());
        return modelAndView;
    }
    @RequestMapping("/checkout")
    public String showCheckout(){
        return "checkout";
    }
    @PostMapping("/checkout")
    public String checkout(@RequestParam String email, @ModelAttribute Cart cart){
        System.out.println(email);
        emailService.sendSimpleMessage(email,"Đơn hàng","tổng tiền đơn hàng của bạn là: "+cart.countTotalPayment());
        cart.clear();
        return "redirect:/shop";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("increase")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("reduce")) {
            cart.reduceProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("delete")) {
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}
