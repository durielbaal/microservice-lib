package com.myke.studios.infraestructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto of pokemon info.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDto implements Serializable {
  /**
   * pokedexNumber.
   */
  @JsonProperty("id")
  public String pokedexNumber;
  /**
   * name.
   */
  public String name;
}
