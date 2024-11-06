package com.myke.studios.pokemonevent.insert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myke.studios.abstracts.AbstractPokemonEventHeader;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonInsertEventHeader extends AbstractPokemonEventHeader {
  /**
   * Event Identificator.
   * //this.id = UUID.randomUUID().toString().replace("-","");
   */
  private String id;
  /**
   * Microservice which created the event.
   */
  private String origin;
  /**
   * Topic of event.
   */
  private String eventType;
  /**
   * Date of event creation.
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime eventDate;

  /**
   * Constructor.
   * @param origin .
   * @param eventType .
   */
  public PokemonInsertEventHeader(String origin,String eventType){
    super();
    this.origin = origin;
    this.eventType = eventType;
    this.id = UUID.randomUUID().toString().replace("-","");
    this.eventDate = LocalDateTime.now();
  }
}
