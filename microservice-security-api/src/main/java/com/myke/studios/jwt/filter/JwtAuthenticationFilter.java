package com.myke.studios.jwt.filter;

import com.myke.studios.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * JWT authentication filter.
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  /**
   * Service used to validate JWT and extract user information.
   */
  private final JwtService jwtService;

  /**
   * Filters incoming requests to extract and validate the JWT token.
   * If valid, the user authentication is set in the security context.
   *
   * @param request the HTTP request.
   * @param response the HTTP response.
   * @param filterChain the filter chain for further processing.
   * @throws ServletException if a servlet error occurs.
   * @throws IOException if an I/O error occurs.
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain)
      throws ServletException, IOException {

    String token = getJwtFromRequest(request);

    if (token != null && jwtService.validateToken(token)) {
      String username = jwtService.getUsernameFromToken(token);
      List<String> roles = jwtService.getRolesFromToken(token);
      List<SimpleGrantedAuthority> authorities = roles.stream()
          .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
          .toList();

      UsernamePasswordAuthenticationToken authentication =
          new UsernamePasswordAuthenticationToken(username, null, authorities);
      authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }

  /**
   * Extracts the JWT token from the Authorization header of the request.
   *
   * @param request the HTTP request.
   * @return the JWT token, or null if not found.
   */
  private String getJwtFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }
}