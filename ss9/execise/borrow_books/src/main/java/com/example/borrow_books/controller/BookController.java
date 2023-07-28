package com.example.borrow_books.controller;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.User;
import com.example.borrow_books.service.book.IBookService;
import com.example.borrow_books.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")

public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @RequestMapping("/list")
    public String showList(Model model){
        List<Book> bookList= bookService.getAll();
        model.addAttribute("list",bookList);
        return "list";
    }
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model ){
        Book book = bookService.getById(id);
        model.addAttribute("book",book);
        return "detail";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam int id,Model model){
        Book book = bookService.getById(id);
        if(book.getQuantity()>0) {
            book.setQuantity(book.getQuantity() - 1);
        }else {
            return "detail";
        }
        User user = new User(book);
        int code = userService.add(user);
        model.addAttribute("code",code);
        return "code";
    }
    @RequestMapping("/give-book-back")
    public String showFormGiveBook(){
        return "give_book";
    }
    @PostMapping("/give-book-back")
    public String giveBookBack(@RequestParam int bookCode,RedirectAttributes redirectAttributes){
       User user = userService.getByCode(bookCode);
       Book book = user.getBook();
       book.setQuantity(book.getQuantity()+1);
        boolean check = userService.deleteByCode(bookCode);
        if(!check){
            return "error";
        }
        return "redirect:/book/list";
    }
}
