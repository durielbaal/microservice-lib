package com.myke.studios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Store the type of pokemon. It's' used by "Types".
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDto {
  /**
   * The text of type.
   */
  private String name;

}
