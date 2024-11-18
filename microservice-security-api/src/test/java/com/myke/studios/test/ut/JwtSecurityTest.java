package com.myke.studios.test.ut;

import com.myke.studios.Initializer;
import com.myke.studios.config.AnyUserAuthConfig;
import com.myke.studios.dto.UserDto;
import com.myke.studios.jwt.JwtService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Slf4j
@SpringBootTest(classes = Initializer.class)
public class JwtSecurityTest {

  @Autowired
  private JwtService jwtService;
  @Autowired
  private AnyUserAuthConfig authenticationManager;
  @Autowired
  private PasswordEncoder passwordEncoder;


  @Test
  @PreAuthorize("hasRole('ROLE_user')")
  void tokenTest() {
    UserDto userDataBase =
        new UserDto("userTest",passwordEncoder.encode("pswTest"),new ArrayList<>(List.of("user","admin")));
    UserDto userRequested =
        new UserDto("userTest","pswTest",new ArrayList<>(List.of("user","admin")));
    authenticationManager.setUserDto(userDataBase);
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
        (userRequested.getUsername(),userRequested.getPassword()));
    String token = jwtService.generateToken(authentication);
    assert token != null && !token.isEmpty();
    assert jwtService.validateToken(token);
    assert userRequested.getUsername().equals(jwtService.getUsernameFromToken(token));

    assert jwtService.getRolesFromToken(token).stream().toList()
        .containsAll(userRequested.getAuthorities().stream().map(SimpleGrantedAuthority::getAuthority).toList());
    System.out.println("token: " + token);
    System.out.println("user from token: " + jwtService.getUsernameFromToken(token));
    System.out.println("user roles from token: " + jwtService.getRolesFromToken(token));
  }
}
