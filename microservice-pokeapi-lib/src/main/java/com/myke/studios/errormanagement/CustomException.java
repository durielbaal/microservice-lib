package com.myke.studios.errormanagement;

/**
 * Customized exception.
 */
public class CustomException extends RuntimeException {
  /**
   * Return message of customized error.
   * @param message customized error message.
   */
  public CustomException(String message) {
    super(message);
  }
}
