package com.myke.studios.jwt.filter;

import com.myke.studios.jwt.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * JWT Filter.
 */
@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {


  /**
   * JWT Service.
   */
  private final JwtService jwtService;

  /**
   * Injection of JWT Service.
   * @param jwtService .
   */
  public JwtAuthenticationFilter(JwtService jwtService) {
    this.jwtService = jwtService;
  }


  /**
   * Filter.
   * @param request .
   * @param response .
   * @param chain .
   * @throws ServletException .
   * @throws IOException .
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request,
      HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {

    String authorizationHeader = request.getHeader("Authorization");

    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      String token = authorizationHeader.substring(7);
      try {
        Claims claims = jwtService.validateToken(token);
        if (claims != null) {
          UsernamePasswordAuthenticationToken authentication =
              new UsernamePasswordAuthenticationToken(null, null, Collections.emptyList());
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

          SecurityContextHolder.getContext().setAuthentication(authentication);
        }
      } catch (Exception e) {
        log.info("Token error: {}", e.getMessage());
      }
    }
    chain.doFilter(request, response);
  }
}