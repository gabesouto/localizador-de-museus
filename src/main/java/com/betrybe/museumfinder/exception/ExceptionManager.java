package com.betrybe.museumfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the Museum Finder application.
 */
@ControllerAdvice
public class ExceptionManager {

  /**
   * Handles the exception when a museum is not found.
   *
   * @param exception The exception of type MuseumNotFoundException.
   * @return ResponseEntity with a NOT_FOUND status and the exception message.
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFound(
      MuseumNotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  /**
   * Handles the exception when an invalid coordinate is encountered.
   *
   * @param exception The exception of type InvalidCoordinateException.
   * @return ResponseEntity with a BAD_REQUEST status and the exception message.
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinate(InvalidCoordinateException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }
}
