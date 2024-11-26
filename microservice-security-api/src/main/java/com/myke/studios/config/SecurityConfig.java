package com.myke.studios.config;

import com.myke.studios.jwt.filter.JwtAuthenticationFilter;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
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
  public SecurityFilterChain securityStandardFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/swagger-ui.html", "/swagger-ui/**",
                    "/v3/api-docs/**").permitAll()
                .requestMatchers("/api/auth/register").permitAll()
                .requestMatchers("api/auth/login").permitAll()
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

  /**
   * Adding security header to our JWT security system.
   * @return .
   */
  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .info(new Info().title("Pokeapi").version("1.0")
            .description("API to pokeapi"))
        .addSecurityItem(new SecurityRequirement().addList("JWT"))
        .components(new io.swagger.v3.oas.models.Components()
            .addSecuritySchemes("JWT", new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")));
  }



}