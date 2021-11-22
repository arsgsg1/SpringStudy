package com.login.example.demo.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity IllegalArgumentExceptionAdvice(IllegalArgumentException e){
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
