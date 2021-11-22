package com.login.example.demo.repository;

import com.login.example.demo.domain.LoginUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<LoginUser, Long> {
  Optional<LoginUser> findByUserId(String userId);
}
