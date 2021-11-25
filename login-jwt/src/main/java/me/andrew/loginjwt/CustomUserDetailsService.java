package me.andrew.loginjwt;

import java.util.List;
import java.util.stream.Collectors;
import me.andrew.loginjwt.domain.User;
import me.andrew.loginjwt.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findOneWithAuthoritiesByUsername(username)
        .map(user -> createUser(username, user))
        .orElseThrow(() -> new UsernameNotFoundException(username + " -> 찾을 수 없음"));
  }

  private org.springframework.security.core.userdetails.User createUser(String username, User user){
    if(!user.isActivated()){
      throw new RuntimeException(username + "-> 활성화 X");
    }
    List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
        .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
        .collect(Collectors.toList());
    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(),
        grantedAuthorities);
  }
}
