package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {
    @GetMapping("/calculator/x")
    public String calculator(){
        return "app";
    }
    @GetMapping("/calculator")
    public String showCalculator(){
        return "app";
    }
}
