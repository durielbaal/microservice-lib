package com.myke.studios.userevent.register;

import com.myke.studios.abstracts.AbstractUserEventBody;
import com.myke.studios.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *User insert Event body.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegisterBody extends AbstractUserEventBody {

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
