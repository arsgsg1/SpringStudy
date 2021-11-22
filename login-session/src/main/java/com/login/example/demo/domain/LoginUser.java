package com.login.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "login_user")
public class LoginUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_pk")
  private Long id;
  @Column(name = "user_id")
  private String userId;
  @Column(name = "password")
  private String password;
  protected LoginUser(){};
  public LoginUser(String userId, String password){
    this.userId = userId;
    this.password = password;
  }
}
