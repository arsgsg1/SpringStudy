package com.login.example.demo.common;

import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    HttpSession userSession = (HttpSession) request.getSession(false);
    if(userSession == null || userSession.getAttribute(SessionConst.LOGIN_ID) == null){
      throw new IllegalAccessException("등록되지 않은 사용자입니다.");
    }

    return true;
  }
}
