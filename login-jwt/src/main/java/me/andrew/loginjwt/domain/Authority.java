package me.andrew.loginjwt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "authority")
@Getter
public class Authority {

  @Id
  @Column(name = "authority_name", length = 50)
  private String authorityName;

  protected Authority() {};
}