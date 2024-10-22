package com.myke.studios.test.ut;

import com.myke.studios.Initializer;
import com.myke.studios.jwt.JwtService;
import io.jsonwebtoken.lang.Classes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Initializer.class)
public class JwtSecurityTest {
  @Autowired
  private JwtService jwtService;

  @Test
  public void tokenTest() {
    System.out.println(jwtService.createToken());
  }
}
