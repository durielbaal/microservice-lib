package com.myke.studios;

import com.myke.studios.abstracts.AbstractEvent;
import com.myke.studios.infraestructure.dto.PokemonDto;

/**
 * Pokemon event.
 */
public class PokemonEvent extends AbstractEvent<PokemonDto> {
  public PokemonEvent(PokemonDto pokemonDto, String origin, String eventType) {
    super(origin, eventType);
    this.setBody(pokemonDto);
  }

  /**
   * Default constructor.
   */
  public  PokemonEvent(){}
}
