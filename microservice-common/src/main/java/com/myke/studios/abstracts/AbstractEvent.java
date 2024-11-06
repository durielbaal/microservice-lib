package com.myke.studios.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Generic event with header and body to manage info.
 * Its like a package with container and header info.
 * @param <H> header.
 * @param <B> body.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "events")
public  abstract class AbstractEvent<H, B> {
  /**
   * info container to know what to do with body.
   */
  private H header;
  /**
   * the object we want to send.
   */
  private B body;
}
