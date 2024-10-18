package com.myke.studios.exception;

import com.myke.studios.exception.enums.GenericTypeException;

/**
 * Generic exception.
 */
public class GenericException extends PokemonException {

  /**
   * constructor with info parameters of customed exception.
   * @param ex generic exception.
   */
  public GenericException(GenericTypeException ex) {
    super(ex.getCode(), ex.getStatus(), ex.getMessage(), null);

  }

}
