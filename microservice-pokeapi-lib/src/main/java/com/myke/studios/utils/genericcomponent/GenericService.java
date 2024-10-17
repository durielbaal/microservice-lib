package com.myke.studios.utils.genericcomponent;

import com.myke.studios.errormanagement.CustomException;
import com.myke.studios.errormanagement.ErrorType;
import com.myke.studios.utils.genericinterface.GenericServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Generic service to work with any kind of object to API management.
 */
public abstract class GenericService implements GenericServiceInterface {
  /**
   * restTemplate to connect API.
   */
  private final RestTemplate restTemplate;
  /**
   * dependency injection.
   * @param restTemplate .
   */

  @Autowired
  protected GenericService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * Manage ANY service in a generic manner.
   * @param <T> generic object.
   * @param endpoint .
   * @param responseType generic type. Any kind of object to get a response.
   * @return generic response.
   */
  @Override
  public <T> T getResponse(String endpoint, Class<T> responseType) {
    /**
     * ANY endpoint to manage ANY Service.
     */
    String url = UriComponentsBuilder.fromHttpUrl(endpoint)
            .toUriString();
    try {
      return restTemplate.getForObject(url, responseType);
    } catch (HttpClientErrorException.NotFound e) {
      throw new CustomException(ErrorType.POKEMON_NOT_FOUND.getMessage());
    } catch (Exception e) {
      throw new CustomException(ErrorType.API_REQUEST_FAILED.getMessage());
    }
  }
}
