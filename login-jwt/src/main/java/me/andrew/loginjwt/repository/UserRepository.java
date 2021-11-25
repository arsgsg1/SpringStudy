package me.andrew.loginjwt.repository;

import java.util.Optional;
import me.andrew.loginjwt.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  @EntityGraph(attributePaths = "authorities")
  Optional<User> findOneWithAuthoritiesByUsername(String username);
}
