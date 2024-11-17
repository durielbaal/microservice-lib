package com.myke.studios.config;

import com.myke.studios.jwt.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration class for securing the application using JWT and roles-based authentication.
 * This class manages roles, sessions, and JWT-based security.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  /**
   * JWT authentication filter for intercepting and validating the token.
   */
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  /**
   * Configures HTTP security for the application with role-based authentication and JWT.
   * This method configures JWT-based authentication, roles, and
   * session management.
   *
   * @param http the HttpSecurity instance to configure the application's security.
   * @return The configured SecurityFilterChain bean.
   * @throws Exception if there is an error during configuration.
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/api/auth/register").permitAll()
                .requestMatchers("/auth/login").permitAll()
                .anyRequest().authenticated()
        )
        .addFilterBefore(jwtAuthenticationFilter,
            UsernamePasswordAuthenticationFilter.class)
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
    return http.build();
  }

  /**
   * Provides a PasswordEncoder bean using BCrypt for hashing passwords.
   * The BCrypt algorithm is a secure password hashing function.
   * @return PasswordEncoder bean.
   */
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }




}