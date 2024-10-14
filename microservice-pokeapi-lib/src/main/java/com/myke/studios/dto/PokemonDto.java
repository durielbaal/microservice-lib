package com.myke.studios.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto pokedb.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDto implements Serializable {
  /**
   * List of abilities.
   */
  public List<AbilitiesDto> abilities;
}