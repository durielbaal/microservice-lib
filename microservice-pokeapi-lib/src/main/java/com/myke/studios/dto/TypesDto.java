package com.myke.studios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Stores all types of pokemon.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypesDto {
  /**
   * Stores one to two types of pokemon.
   */
  private TypeDto type;
}
