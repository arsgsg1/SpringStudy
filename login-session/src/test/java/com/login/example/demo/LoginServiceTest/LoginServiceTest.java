package com.login.example.demo.LoginServiceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.example.demo.domain.LoginUser;
import com.login.example.demo.repository.UserRepository;
import com.login.example.demo.service.dto.request.RequestLoginDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginServiceTest {
  @Autowired
  private MockMvc mvc;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ObjectMapper mapper;

  @BeforeEach
  public void setup(){
    userRepository.save(new LoginUser("arsgsg", "1234"));
  }

  @Test
  @DisplayName("로그인 성공, 실패 테스트")
  public void loginTest() throws Exception {
    String userId = "arsgsg"; String password = "1234"; String invalidPassword = "1324";
    RequestLoginDto dto = new RequestLoginDto(userId, password);
    String json = mapper.writeValueAsString(dto);
    mvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print());

    dto = new RequestLoginDto(userId, invalidPassword);
    json = mapper.writeValueAsString(dto);
    mvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andDo(MockMvcResultHandlers.print());
  }
}
