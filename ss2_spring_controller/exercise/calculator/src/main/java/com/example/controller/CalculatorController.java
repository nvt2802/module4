package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @PostMapping("/calculator")
    public String calculator(@RequestParam String operator, @RequestParam double first,
                             @RequestParam double second, Model model) {
        try {
            double result = Calculator.calculate(first,second, operator);
            model.addAttribute("result",Double.toString(result));
        }catch (NumberFormatException numberFormatException) {
            model.addAttribute("result", numberFormatException.getMessage());
        } catch (Exception ex) {
            model.addAttribute("result",ex.getMessage());
        }
        return "app";
    }

    @RequestMapping("/calculator")
    public String showCalculator() {
        return "app";
    }
}
