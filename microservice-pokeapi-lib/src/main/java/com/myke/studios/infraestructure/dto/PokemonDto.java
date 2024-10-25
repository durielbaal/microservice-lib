package com.myke.studios.infraestructure.dto;

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
   * id.
   */
  public String id;
  /**
   * name.
   */
  public String name;
}
