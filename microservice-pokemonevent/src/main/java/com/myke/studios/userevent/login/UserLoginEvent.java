package com.myke.studios.userevent.login;

import com.myke.studios.abstracts.AbstractUserEvent;
import com.myke.studios.constant.ConstantEvent;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User login event.
 */
@NoArgsConstructor
@Document(collection = "UserLoginEvents")
public class UserLoginEvent extends AbstractUserEvent<UserLoginEventHeader, UserLoginBody> {


  /**
   * Static event type
   */
  private static final String EVENT_TYPE = ConstantEvent.USER_LOGIN_EVENT;

  /**
   * Constructor.
   * @param body .
   */
  public UserLoginEvent(UserLoginBody body){
    super(new UserLoginEventHeader(ORIGIN,EVENT_TYPE),body);
  }

  @Override
  public UserLoginEventHeader getHeader() {
    return super.getHeader();
  }
  @Override
  public UserLoginBody getBody(){
    return super.getBody();
  }
}
