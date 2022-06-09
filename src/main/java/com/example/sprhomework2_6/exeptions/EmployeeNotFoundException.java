package com.example.sprhomework2_6.exeptions;
//
public class EmployeeNotFoundException  extends RuntimeException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
