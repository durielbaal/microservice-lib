package com.myke.studios.errormanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum of errors.
 */
@Getter
@AllArgsConstructor
public enum ErrorType {
  /**
   * Pokemon not found when we are searching.
   */
  POKEMON_NOT_FOUND("Pokémon not found."),
  /**
   * Generic error.
   */
  API_REQUEST_FAILED("API request has failed.");
  /**
   * Message of error.
   */
  private final String message;
}