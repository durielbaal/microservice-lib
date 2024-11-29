package com.myke.studios.infraestructure.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialsDto implements Serializable {

  /**
   * Username.
   */
  private String username;
  /**
   * Password.
   */
  private String password;
}
