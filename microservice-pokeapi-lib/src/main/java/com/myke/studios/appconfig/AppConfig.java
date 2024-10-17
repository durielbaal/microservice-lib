package com.myke.studios.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class.
 */
@Configuration
public class AppConfig {

  /**
   * dependencies injection restemplate.
   * @return new dependency injection of template.
   */
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
