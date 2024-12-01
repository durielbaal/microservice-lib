package com.myke.studios.userevent.register;

import com.myke.studios.abstracts.AbstractUserEvent;
import com.myke.studios.constant.ConstantEvent;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User register event.
 */
@NoArgsConstructor
@Document(collection = "UserRegisterEvents")
public class UserRegisterEvent extends AbstractUserEvent<UserRegisterEventHeader, UserRegisterBody> {


  /**
   * Static event type
   */
  private static final String EVENT_TYPE = ConstantEvent.USER_REGISTER_EVENT;

  /**
   * Constructor.
   * @param body .
   */
  public UserRegisterEvent(UserRegisterBody body){
    super(new UserRegisterEventHeader(ORIGIN,EVENT_TYPE),body);
  }

  @Override
  public UserRegisterEventHeader getHeader() {
    return super.getHeader();
  }
  @Override
  public UserRegisterBody getBody(){
    return super.getBody();
  }
}
