package com.myke.studios.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Confiouration class.
 */
@Configuration
public class AppConfig {

  /**
   * RestTemplate configuration.
   * @return restTemplate.
   */
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /**
   * Mapper configuration.
   * @return ObjectMapper.
   */
  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
