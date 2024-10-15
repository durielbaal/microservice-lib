package com.myke.studios.errormanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Error handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  /**
   * Not found.
   * @param ex customized error excepction.
   * @return customized error.
   */
  @ExceptionHandler(HttpClientErrorException.NotFound.class)
  public ResponseEntity<String> handleCustomException(CustomException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  /**
   * Generic error.
   * @param ex customized error excepction.
   * @return customized error.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGeneralException(CustomException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
