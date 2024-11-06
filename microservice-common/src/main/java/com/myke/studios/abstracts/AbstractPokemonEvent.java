package com.myke.studios.abstracts;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * generic pokemon event template.
 * @param <B> body.
 * @param <H> header.
 */
@NoArgsConstructor
public abstract class AbstractPokemonEvent
    <H extends AbstractPokemonEventHeader, B extends  AbstractPokemonEventBody>
    extends AbstractEvent<H,B> {

  /**
   * Static origin of this event.
   */
  protected static final String ORIGIN = "POKEAPI";

  /**
   * Constructor.
   * @param header metainfo container.
   * @param body data itself.
   */
  public AbstractPokemonEvent(H header, B body) {
    super(header,body);
  }
}
