package com.myke.studios.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Object Abilities to get everything about abilities, including is_hidden and slot.
 */
@Data
public class AbilitiesDto {
  /**
   * Ability itself.
   */
  private AbilityDto ability;
  /**
   * we print if this ability is hidden for the pokemon.
   */
  @JsonProperty("is_hidden")
  private boolean isHidden;
  /**
   * number of slots.
   */
  private int slot;
}
