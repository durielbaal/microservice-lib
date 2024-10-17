package com.myke.studios.utils.genericinterface;

import com.myke.studios.utils.genericcomponent.GenericService;

/**
 * Interface of generic controller.
 */
public  interface GenericControllerInterface {

  /**
   *  Generic getResponse.
   * @param id ID of generic controller
   * @param <T> generic object.
   * @param gs Generic Service.
   * @param responseType type of response
   * @return generic response
   */
  public <T> T getPokemon(String id, GenericService gs,Class<T> responseType);

}
