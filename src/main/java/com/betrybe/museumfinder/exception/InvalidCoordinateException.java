package com.betrybe.museumfinder.exception;

/**
 * Exception thrown when an invalid coordinate is encountered.
 */
public class InvalidCoordinateException extends RuntimeException {

  /**
   * Constructs an InvalidCoordinateException with a default error message.
   */
  public InvalidCoordinateException() {
    super("Invalid coordinate");
  }
}

