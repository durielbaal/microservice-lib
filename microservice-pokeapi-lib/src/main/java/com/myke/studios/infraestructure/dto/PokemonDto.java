package com.myke.studios.infraestructure.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * Dto of pokemon info.
 */
@Data
public class PokemonDto implements Serializable {
  /**
   * id.
   */
  public final String id;
  /**
   * name.
   */
  public final String name;
}
