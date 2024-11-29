package com.myke.studios.config;

import com.myke.studios.abstracts.AbstractAuthConfig;
import com.myke.studios.enums.Role;
import java.util.Arrays;
import java.util.List;
import org.springframework.security.authentication.BadCredentialsException;
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
   * Add requirements to authenticate.
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
    List<String> allAuthorities = Arrays.stream(Role.values())
        .map(role -> new SimpleGrantedAuthority(role.getRoleName()).getAuthority()).toList();

    return this.getUserDto().getRoles().stream()
        .anyMatch(allAuthorities::contains);
  }

}
