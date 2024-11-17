package com.myke.studios.config;

import com.myke.studios.abstracts.AbstractAuthConfig;
import com.myke.studios.enums.Role;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * AuthConfig to get any user rol.
 */
@Component
public class AnyUserAuthConfig extends AbstractAuthConfig {

  /**
   * constructor.
   * @param passwordEncoder .
   */
  public AnyUserAuthConfig(PasswordEncoder passwordEncoder) {
    super(passwordEncoder);
  }

  /**
   * Abstract method to authenticate the user.
   * This method should be implemented by subclasses to provide custom authentication logic.
   * @param username the username of the user.
   * @param password the password of the user.
   * @return the authentication token if authentication is successful.
   * @throws BadCredentialsException if the credentials are invalid.
   */
  @Override
  protected Authentication addAuthRequirements(String username, String password)
      throws BadCredentialsException {
    return new UsernamePasswordAuthenticationToken(username, password,
        this.getUserDto().getAuthorities());
  }

  /**
   *  Do the user has the necessary role?.
   * @return true or false.
   */
  @Override
  protected boolean hasRole() {
    if (this.getUserDto().getAuthorities().isEmpty()) {
      return false;
    }
    List<SimpleGrantedAuthority> allAuthorities = Arrays.stream(Role.values())
        .map(role -> new SimpleGrantedAuthority(role.getRoleName())).toList();

    return this.getUserDto().getAuthorities().stream()
        .anyMatch(allAuthorities::contains);
  }

}
