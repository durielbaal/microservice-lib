package com.myke.studios.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Generic event with header and body to manage info.
 * Its like a package with container and header info.
 * @param <T> .
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "events")
public  abstract class AbstractEvent<T> {

  /**
   * Event Identificator.
   */
  @Id
  private String id; //
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
   * the object we want to send.
   */
  private T body;

  /**
   * Constructor AbstractEvent.
   * @param origin origin of event creation.
   * @param eventType topic of event.
   */
  protected AbstractEvent(String origin, String eventType) {
    this.origin = origin;
    this.eventDate = LocalDateTime.now();
    this.eventType = eventType;
    this.id = UUID.randomUUID().toString().replace("-","");
  }

}
