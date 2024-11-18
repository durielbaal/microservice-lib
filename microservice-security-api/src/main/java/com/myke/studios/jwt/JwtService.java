package com.myke.studios.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * Jwt Service.
 */
@Service
public class JwtService {

  /**
   * Secret key used for signing and validating JWT tokens.
   * Injected from the application configuration.
   */
  private final SecretKey jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS512);
  /**
   * Expiration time for JWT tokens in milliseconds.
   * Injected from the application configuration.
   */
  @Value("${jwt.expiration_time}")
  private long jwtExpirationInMs;

  /**
   * Generates a JWT token for the given Authentication object.
   *
   * @param authentication the authenticated user's information.
   * @return the generated JWT token.
   */
  public String generateToken(Authentication authentication) {
    String username = authentication.getName();
    List<String> roles = authentication.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .toList();

    Claims claims = Jwts.claims().setSubject(username);
    claims.put("roles", roles);

    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(expiryDate)
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  /**
   * Extracts the username from the JWT token.
   *
   * @param token the JWT token.
   * @return the username extracted from the token.
   */
  public String getUsernameFromToken(String token) {
    return Jwts.parser()
        .setSigningKey(jwtSecret)
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  /**
   * Extracts the roles from the JWT token.
   *
   * @param token the JWT token.
   * @return a list of roles extracted from the token.
   */
  public List<String> getRolesFromToken(String token) {
    Claims claims = Jwts.parser()
        .setSigningKey(jwtSecret)
        .parseClaimsJws(token)
        .getBody();

    return (List<String>) claims.get("roles");
  }

  /**
   * Validates the JWT token.
   * @param token the JWT token.
   * @return true if the token is valid, false otherwise.
   */
  public boolean validateToken(String token) {
    try {
      Jwts.parser()
          .setSigningKey(jwtSecret)
          .parseClaimsJws(token);  // Parse the token to check validity
      return true;
    } catch (SignatureException | MalformedJwtException | ExpiredJwtException
             | UnsupportedJwtException | IllegalArgumentException e) {
      // Handle specific exceptions for token validation
      return false;
    }
  }

  /**
   * Builds the granted authorities from the roles stored in the JWT token.
   *
   * @param token the JWT token.
   * @return a list of GrantedAuthority objects representing the roles.
   */
  public List<SimpleGrantedAuthority> getAuthoritiesFromToken(String token) {
    List<String> roles = getRolesFromToken(token);
    return roles.stream()
        .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role))) // Prefix with ""
        .toList();
  }
}