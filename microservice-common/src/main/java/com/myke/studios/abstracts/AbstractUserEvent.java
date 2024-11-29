package com.myke.studios.abstracts;

import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Abstract event for user.
 * @param <H> header of user event.
 * @param <B> body of user event.
 */
@Data
@NoArgsConstructor
public class AbstractUserEvent<H extends AbstractEventHeader,
    B extends AbstractUserEventBody> extends AbstractEvent<H, B> {

  /**
   * Id.
   */
  private String id;
  /**
   * Static origin of this event.
   */
  protected static final String ORIGIN = "POKEAPI";

  /**
   * Constructor.
   * @param header metainfo container.
   * @param body data itself.
   */
  public AbstractUserEvent(H header, B body) {
    super(header,body);
    id = UUID.randomUUID().toString().replace("-","");
  }
}
