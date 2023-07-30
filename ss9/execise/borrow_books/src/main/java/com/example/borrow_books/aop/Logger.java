package com.example.borrow_books.aop;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.read_and_write_file.ReadAndWriteFile;
import com.example.borrow_books.service.book.BookService;
import com.example.borrow_books.service.book.IBookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count =0;
    @Autowired
   private IBookService bookService;

    @After("execution(* com.example.borrow_books.controller.BookController.*(..))")
    public void count(JoinPoint joinPoint){
        count++;
        ReadAndWriteFile.writeFile("src/main/java/com/example/borrow_books/data/count.csv",String.valueOf(count),false);
        System.out.println("number of hits: " + count);
    }
    // em chưa làm xong phần này a :(((
    @After("execution(* com.example.borrow_books.controller.BookController.borrow(..))")
    public void loggingInfoBorrow(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
       int id = (Integer) args[0];
        System.out.println("id="+id);
       Book book= bookService.getById(id);
        System.out.println(book.getName());
        ReadAndWriteFile.writeFile("src/main/java/com/example/borrow_books/data/history.csv","Book "+book.getName()+" is borrowed",true);
    }

    @After("execution(* com.example.borrow_books.controller.BookController.giveBookBack(..))")
    public void loggingInfoGiveBack(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        int code = (Integer) args[0];
        ReadAndWriteFile.writeFile("src/main/java/com/example/borrow_books/data/history.csv","Code: "+ code +" is give back book",true);
    }

}
