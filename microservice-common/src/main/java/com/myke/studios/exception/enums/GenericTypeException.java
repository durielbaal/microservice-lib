package com.myke.studios.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Generic Type of exception.
 */
@Getter
@RequiredArgsConstructor
public enum GenericTypeException {
  /**
   * Invalid URI.
   */
  INVALID_URI_EXCEPTION(ExceptionCode.C500000001.name(),
          HttpStatus.INTERNAL_SERVER_ERROR,"Invalid Uri"),
  /**
   * inaccessible resource.
   */
  RESOURCE_NOT_ACCESS(ExceptionCode.C500000003.name(),HttpStatus.INTERNAL_SERVER_ERROR,
          "inaccessible resource"),
  /**
   * Unexpected response.
   */
  UNEXPECTED_BODY_RESPONSE(ExceptionCode.C500000003.name(),HttpStatus.INTERNAL_SERVER_ERROR,
          "Unexpected response");
  /**
   * Code of Exception.
   */
  private final String code;
  /**
   * Status of request.
   */
  private final HttpStatus status;
  /**
   * Message of error.
   */
  private  final  String message;
}
