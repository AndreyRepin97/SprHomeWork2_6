package com.example.sprhomework2_6.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//
//@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException  extends RuntimeException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
