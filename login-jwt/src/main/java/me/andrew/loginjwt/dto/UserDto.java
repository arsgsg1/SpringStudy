package me.andrew.loginjwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {
  @NotEmpty
  @Size(min = 3, max = 50)
  private String username;
  @NotEmpty
  @Size(min = 3, max = 100)
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;
  @NotEmpty
  @Size(min = 3, max = 50)
  private String nickname;
}
