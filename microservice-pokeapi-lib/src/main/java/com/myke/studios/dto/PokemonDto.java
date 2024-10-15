package com.myke.studios.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
   * Pokedex number of pokemon.
   */
  @JsonProperty("id")
  public int pokedexId;
  /**
   * Name of pokemon.
   */
  public String name;
  /**
   * Height of pokemon.
   */
  public double height;
  /**
   * Weight of pokemon.
   */
  public double weight;
  /**
   * List of abilities.
   */
  public List<AbilitiesDto> abilities;
  /**
   * Types of pokemon.
   */
  public List<TypesDto> types;
}