package com.myke.studios.config;

import com.myke.studios.abstracts.AbstractAuthConfig;
import java.util.ArrayList;
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
   *
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
  protected Authentication authenticateUser(String username, String password)
      throws BadCredentialsException {

    if (this.getUserDto() == null) {
      throw new BadCredentialsException("User not found");
    }

    if (!passwordEncoder.matches(password, this.getUserDto().getPassword())) {
      throw new BadCredentialsException("Invalid username or password");
    }

    if (!hasRole()) {
      throw new BadCredentialsException("User has no roles assigned");
    }

    return new UsernamePasswordAuthenticationToken(username, password,
        this.getUserDto().getAuthorities());
  }

  /**
   *  Do the user has the necessary role?.
   * @return true or false.
   */
  private boolean hasRole() {
    if (this.getUserDto().getAuthorities().isEmpty()) {
      return false;
    }
    Set<SimpleGrantedAuthority> allAuthorities = new HashSet<>();
    allAuthorities.add(new SimpleGrantedAuthority("ROLE_admin"));
    allAuthorities.add(new SimpleGrantedAuthority("ROLE_user"));

    return this.getUserDto().getAuthorities().stream()
        .anyMatch(allAuthorities::contains);
  }

}
