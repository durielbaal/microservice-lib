package com.myke.studios.userevent.login;

import com.myke.studios.abstracts.AbstractUserEventHeader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User login Header event.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginEventHeader extends AbstractUserEventHeader {
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
  private String eventDate;
  /**
   * Response of register.
   */
  private String response;

  /**
   * Constructor.
   * @param origin .
   * @param eventType .
   */
  public UserLoginEventHeader(String origin,String eventType){
    super();
    this.origin = origin;
    this.eventType = eventType;
    this.id = UUID.randomUUID().toString().replace("-","");
    this.eventDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
  }
}
