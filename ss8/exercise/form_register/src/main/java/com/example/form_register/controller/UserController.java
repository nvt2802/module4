package com.example.form_register.controller;

import com.example.form_register.dto.UserDto;
import com.example.form_register.model.User;
import com.example.form_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @RequestMapping("/register")
    public ModelAndView showForm(){
        UserDto userDto = new UserDto();
        ModelAndView modelAndView = new ModelAndView("form_register");
        modelAndView.addObject("userDto",userDto);
        return modelAndView;
    }

    @PostMapping("/register")
    public  String register(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult,Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "form_register";
        }
        User user1 = new User();
        BeanUtils.copyProperties(userDto, user1);
        boolean check = userService.add(user1);
        if (!check) {
            return "form_register";
        }
        User user = userService.getUser(user1.getId());
        model.addAttribute("user",user);
        return "user";
    }}
