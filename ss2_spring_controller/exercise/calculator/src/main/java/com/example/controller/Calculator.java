package com.example.controller;

public class Calculator {
    public static double calculate(double firstNum,double secondNum,String operator){
        double result ;
        switch (operator){
            case "+":
                result=firstNum + secondNum;
                break;
            case "-":
                result=firstNum - secondNum;
                break;
            case "*":
                result=firstNum * secondNum;
                break;
            case "/":
                if(secondNum!=0) {
                    result = firstNum / secondNum;
                }else {
                    throw new ArithmeticException("Can't divide by zero");
                }
                break;
            default:
                throw new ArithmeticException("Invalid operation");
        }
        return result;
    }
}
