package com.myke.studios.utils.genericcomponent;

import com.myke.studios.errormanagement.CustomException;
import com.myke.studios.errormanagement.ErrorType;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Generic Controller.
 */
public class GenericController {
  /**
   *  Generic getResponse.
   * @param id ID of generic controller
   * @param <T> generic object.
   * @param gs Generic Service.
   * @param responseType type of response
   * @return generic response
   */
  public <T> T getResponse(@PathVariable String id,GenericService gs,Class<T> responseType) {
    try {
      return  gs.getResponse(id,responseType);
    } catch (Exception e) {
      throw new CustomException(ErrorType.API_REQUEST_FAILED.getMessage());
    }

  }
}
