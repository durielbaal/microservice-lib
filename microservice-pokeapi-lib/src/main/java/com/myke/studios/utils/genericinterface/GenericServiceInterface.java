package com.myke.studios.utils.genericinterface;

/**
 * GenericService interface.
 */
public interface GenericServiceInterface {
  /**
   * Manage ANY service in a generic manner.
   * @param <T> generic object.
   * @param endpoint .
   * @param responseType generic type. Any kind of object to get a response.
   * @return generic response.
   */

  public <T> T getResponse(String endpoint,Class<T> responseType);

}
