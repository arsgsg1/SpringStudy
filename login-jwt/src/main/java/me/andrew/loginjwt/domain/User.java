package me.andrew.loginjwt.domain;

import java.util.HashSet;
import javax.persistence.*;
import java.util.Set;
import lombok.Getter;

@Entity
@Table(name = "user")
@Getter
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(name = "username", length = 50, unique = true)
  private String username;

  @Column(name = "password", length = 100)
  private String password;

  @Column(name = "nickname", length = 50)
  private String nickname;

  @Column(name = "activated")
  private boolean activated;

  @ManyToMany
  @JoinTable(
      name = "user_authority",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
  private Set<Authority> authorities = new HashSet<>();

  protected User(){};

  public User(String username, String password,
      Set<Authority> authorities) {
    this.username = username;
    this.password = password;
    this.authorities = authorities;
  }
}
