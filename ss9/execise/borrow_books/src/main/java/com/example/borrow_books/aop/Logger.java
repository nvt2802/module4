package com.example.borrow_books.aop;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.read_and_write_file.ReadAndWriteFile;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count =0;
    @After("execution(* com.example.borrow_books.controller.BookController.*(..))")
    public void count(JoinPoint joinPoint){
        count++;
        ReadAndWriteFile.writeFile("java/com/example/borrow_books/data/count.csv",String.valueOf(count),false);
        System.out.println("number of hits: " + count);
    }
    // em chưa làm xong phần này a :(((
//    @After("execution(* com.example.borrow_books.controller.BookController.borrow(..))")
//    public void loggingInfoBorrow(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        Book book = (Book) args[0];
//        ReadAndWriteFile.writeFile("java/com/example/borrow_books/data/history.csv",book.getName(),true);
//    }

}
