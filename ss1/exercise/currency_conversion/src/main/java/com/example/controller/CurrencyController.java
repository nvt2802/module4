package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @PostMapping("/currency/calculation")
    public String currency(@RequestParam float usd, Model model){
        float vnd = usd *23635;
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        return "app";
    }
    @GetMapping("/currency")
    public String currency(){
        return "app";
    }
}
