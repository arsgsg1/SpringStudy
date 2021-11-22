package com.login.example.demo.controller;

import com.login.example.demo.service.LoginService;
import com.login.example.demo.service.dto.request.RequestLoginDto;
import com.login.example.demo.service.dto.request.RequestSignupDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginContoller {
  private final LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody RequestLoginDto dto, HttpServletRequest request){
    loginService.Login(dto, request);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping("/signup")
  public ResponseEntity signup(@RequestBody RequestSignupDto dto){
    loginService.Signup(dto);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping("/logout")
  public ResponseEntity logout(HttpServletRequest request){
    HttpSession session = request.getSession(false);
    if(session != null){
      session.invalidate();
    }
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
