package com.myke.studios.abstracts;

import com.myke.studios.exception.GenericException;
import com.myke.studios.exception.enums.GenericTypeException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Supplier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;






/**
 * Abstract endpoint.
 */
public abstract class AbstractEndpoint {
  /**
   *  transform path into URI.
   * @param path .
   * @return path in URI format.
   */
  protected URI getUri(String path) {
    try {
      return new URI(path);
    } catch (URISyntaxException e) {
      throw new GenericException(GenericTypeException.INVALID_URI_EXCEPTION);
    }

  }

  /**
   * manage the request.
   * @param supplier .
   * @param <T> .
   * @return the response.
   */
  protected <T> T handleConnection(Supplier<T> supplier) {
    try {
      return supplier.get();
    } catch (ResourceAccessException e) {
      throw new GenericException(GenericTypeException.RESOURCE_NOT_ACCESS);
    }
  }

  /**
   *  extract response.
   * @param <T> .
   * @param responseEntity .
   * @return response.
   */
  protected <T> T extractResponseData(final ResponseEntity<T> responseEntity) {
    final T body = responseEntity.getBody();
    if (body == null) {
      throw new GenericException(GenericTypeException.UNEXPECTED_BODY_RESPONSE);
    }
    return body;
  }

}
