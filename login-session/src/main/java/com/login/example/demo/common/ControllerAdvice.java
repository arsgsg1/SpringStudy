package com.login.example.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity IllegalArgumentExceptionAdvice(IllegalArgumentException e){
    return ResponseEntity.badRequest().body(e.getMessage());
  }

  @ExceptionHandler(IllegalAccessException.class)
  public ResponseEntity IllegalAccessExceptionAdvice(IllegalAccessException e){
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
  }
}
