package com.myke.studios.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Rol enum.
 */
@AllArgsConstructor
@Getter
public enum Role {
  /**
   * Admin rol.
   */
  ADMIN("ROLE_admin","user who take control and access of everything."),
  /**
   * user rol.
   */
  USER("ROLE_user","common user, with terms of use");
  /**
   * rol name.
   */
  private String roleName;
  /**
   * rol description.
   */
  private String roleDescricption;

  @Override
  public String toString() {
    return this.roleName;
  }

}

