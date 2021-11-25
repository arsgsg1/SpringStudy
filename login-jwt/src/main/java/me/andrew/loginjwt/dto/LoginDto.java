package me.andrew.loginjwt.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
  @NotEmpty
  @Size(min = 3, max = 50)
  private String username;

  @NotEmpty
  @Size(min = 3, max = 100)
  private String password;
}
