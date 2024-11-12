package com.myke.studios.pokemonevent.insert;

import com.myke.studios.abstracts.AbstractPokemonEventBody;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class PokemonInsertEventBody extends AbstractPokemonEventBody {
  /**
   * pokedex Number.
   */
  public String pokedexNumber;
  /**
   * name.
   */
  public String name;


}
