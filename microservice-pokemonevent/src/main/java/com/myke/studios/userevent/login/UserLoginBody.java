package com.myke.studios.userevent.login;

import com.myke.studios.abstracts.AbstractUserEventBody;
import com.myke.studios.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *User login Event body.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginBody extends AbstractUserEventBody {

  /**
   * Username.
   */
  public String username;
  /**
   * Password.
   */
  public String password;
  /**
   * Role info.
   */
  public Role role;

}
