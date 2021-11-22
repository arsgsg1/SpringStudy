package com.login.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class LoginUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userId;
  private String password;
  protected LoginUser(){};
  public LoginUser(String userId, String password){
    this.userId = userId;
    this.password = password;
  }
}
