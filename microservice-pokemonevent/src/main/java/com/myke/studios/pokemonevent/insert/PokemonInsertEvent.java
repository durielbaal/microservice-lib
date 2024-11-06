package com.myke.studios.pokemonevent.insert;

import com.myke.studios.abstracts.AbstractPokemonEvent;
import com.myke.studios.constant.ConstantEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pokemon event.
 */
@Data
@NoArgsConstructor
public class PokemonInsertEvent extends AbstractPokemonEvent<PokemonInsertEventHeader, PokemonInsertEventBody> {

  /**
   * Static event type
   */
  private static final String EVENT_TYPE = ConstantEvent.POKEMON_INSERT_EVENT;

  /**
   * Constructor.
   * @param body .
   */
  public PokemonInsertEvent(PokemonInsertEventBody body){
    super(new PokemonInsertEventHeader(ORIGIN,EVENT_TYPE),body);
  }

  @Override
  public PokemonInsertEventHeader getHeader() {
    return super.getHeader();
  }
  @Override
  public PokemonInsertEventBody getBody(){
    return super.getBody();
  }
}
