package com.myke.studios.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.function.Function;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * Service of JWT.
 */
@Service
@PropertySource("classpath:security-api.properties")
public class JwtService {

  /**
   * Secret Key.
   */
  private final SecretKey secretKey;

  /**
   * Customed constructor.
   * @param secretKey .
   */
  public JwtService(@Value("${secret.key}") String secretKey) {
    this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
  }

  /**
   * Token generation.
   * @return token.
   */
  public String createToken() {
    return Jwts.builder()
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
        .signWith(secretKey)
        .compact();
  }

  /**
   *  Validate token.
   * @param token .
   * @return is validated or not.
   */
  public Claims validateToken(String token) {
    return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
  }
}