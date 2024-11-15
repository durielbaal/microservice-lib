package com.myke.studios.abstracts;

import com.myke.studios.dto.UserDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Abstract Authentication manager customization.
 */
@Component
@RequiredArgsConstructor
@Data
public abstract class AbstractAuthConfig implements AuthenticationManager {

  /**
   * password encoder.
   */
  protected final PasswordEncoder passwordEncoder;
  /**
   * Dto de usuario.
   */
  private UserDto userDto;

  /**
   * Abstract method to authenticate the user. This method should be implemented by subclasses
   * to provide custom authentication logic.
   *
   * @param username the username of the user.
   * @param password the password of the user.
   * @return the authentication token if authentication is successful.
   * @throws BadCredentialsException if the credentials are invalid.
   */
  protected abstract Authentication authenticateUser(String username, String password)
      throws BadCredentialsException;

  /**
   * Authenticate user.
   * @param authentication .
   * @return .
   */
  @Override
  public Authentication authenticate(Authentication authentication) {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    // Call the abstract method to perform custom authentication
    return authenticateUser(username, password);
  }

}

