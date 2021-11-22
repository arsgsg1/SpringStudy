package com.login.example.demo.service;

import com.login.example.demo.common.SessionConst;
import com.login.example.demo.domain.LoginUser;
import com.login.example.demo.repository.UserRepository;
import com.login.example.demo.service.dto.request.RequestLoginDto;
import com.login.example.demo.service.dto.request.RequestSignupDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public void Login(RequestLoginDto dto, HttpServletRequest request) {
    LoginUser user = userRepository
        .findByUserId(dto.getUserId())
        .orElseThrow(() -> new IllegalArgumentException("해당 ID의 유저가 없습니다."));

    HttpSession session = request.getSession();
    session.setAttribute(SessionConst.LOGIN_ID, dto.getUserId());
  }

  @Transactional
  public void Signup(RequestSignupDto dto){
    if(userRepository.findByUserId(dto.getUserId()).isPresent()){
      throw new IllegalArgumentException("이미 존재하는 ID입니다.");
    }
    LoginUser newUser = new LoginUser(dto.getUserId(), dto.getPassword());
    userRepository.save(newUser);
  }
}
