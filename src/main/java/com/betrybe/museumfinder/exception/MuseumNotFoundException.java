package com.betrybe.museumfinder.exception;

/**
 * Exception thrown when a museum is not found.
 */
public class MuseumNotFoundException extends RuntimeException {

  /**
   * Constructs a MuseumNotFoundException with a default error message.
   */
  public MuseumNotFoundException() {
    super("Museu não encontrado!");
  }
}
