package com.example.springbootDemo.service.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PermissionAdvice {
    @ExceptionHandler(value = PermissionCheckException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String dealWithPermissionCheckException(PermissionCheckException exception){
        System.out.println(exception.getMessage());
        return exception.getMessage();
    }
}
