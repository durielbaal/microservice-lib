package com.myke.studios.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * User in DTO format.
 */
@Data
@AllArgsConstructor
public class UserDto {

  /**
   * Username.
   */
  private String username;
  /**
   * Password.
   */
  private String password;
  /**
   * List of roles.
   */
  private List<String> roles;

  /**
   * Rol in list of SimpleGrantedAuthority format.
   * @return list of SimpleGrantedAuthority.
   */
  public List<SimpleGrantedAuthority> getAuthorities() {
    return roles.stream()
        .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
        .toList();
  }
}
