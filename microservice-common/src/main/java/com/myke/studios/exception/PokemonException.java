package com.myke.studios.exception;

import org.springframework.http.HttpStatus;

/**
 * Pokemon generic exceptions.
 */
public abstract class PokemonException extends RuntimeException {
  /**
   * status of request.
   */
  private final HttpStatus status;
  /**
   * Code of exception.
   */
  private final String code;

  /**
   * Constructor of pokemon generic Exception.
   * @param code code of exception.
   * @param status status of request.
   * @param message message info.
   * @param throwable it is?.
   */
  protected PokemonException(final String code, final HttpStatus status, final String message,
                             final Throwable throwable) {
    super(message,throwable);
    this.status = status;
    this.code = code;
  }
}
