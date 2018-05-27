package com.example.springbootDemo.service.aspect;

public class PermissionCheckException extends RuntimeException {
    public PermissionCheckException(String message) {
        super(message);
    }
}
