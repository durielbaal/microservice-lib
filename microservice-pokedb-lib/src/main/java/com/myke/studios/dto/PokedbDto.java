package com.myke.studios.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Dto pokedb.
 */
@Data
@Builder
public class PokedbDto {
  /**
   * name of pokemon.
   */
  private String name;
  /**
   * power of pokemon.
   */
  private int power;
}
