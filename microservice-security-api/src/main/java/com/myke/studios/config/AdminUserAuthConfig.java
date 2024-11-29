package com.myke.studios.config;

import com.myke.studios.abstracts.AbstractAuthConfig;
import com.myke.studios.enums.Role;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * AuthConfig to get any user rol.
 */
public class AdminUserAuthConfig extends AbstractAuthConfig {

  /**
   * constructor.
   *
   * @param passwordEncoder .
   */
  public AdminUserAuthConfig(PasswordEncoder passwordEncoder) {
    super(passwordEncoder);
  }

  /**
   * Abstract method to authenticate the user.
   * This method should be implemented by subclasses to provide custom authentication logic.
   * @param username the username of the user.
   * @param password the password of the user.
   * @throws BadCredentialsException if the credentials are invalid.
   */
  @Override
  protected void addAuthRequirements(String username, String password)
      throws BadCredentialsException {


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
    return this.getUserDto().getAuthorities().stream()
        .anyMatch(authority -> authority.getAuthority().equals(Role.ADMIN.getRoleName()));
  }

}
