package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.entities.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling museum-related operations.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase museumFakeDatabase;

  /**
   * Constructor for MuseumService.
   *
   * @param museumFakeDatabase The database implementation for museums.
   */
  @Autowired
  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  /**
   * Gets the closest museum to the specified coordinate within the given maximum distance.
   *
   * @param coordinate  The coordinate to find the closest museum to.
   * @param maxDistance The maximum distance within which to search for museums.
   * @return The closest museum.
   * @throws InvalidCoordinateException if the coordinate is invalid.
   * @throws MuseumNotFoundException    if no museums are found within the specified distance.
   */
  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    Boolean isCoordinateValid = CoordinateUtil.isCoordinateValid(coordinate);
    if (!isCoordinateValid) {
      throw new InvalidCoordinateException();
    }
    Optional<Museum> closestMuseum = this.museumFakeDatabase.getClosestMuseum(coordinate,
        maxDistance);
    return closestMuseum.orElseThrow(MuseumNotFoundException::new);
  }

  /**
   * Creates a new museum based on the provided information.
   *
   * @param museum The museum object to be created.
   * @return The created museum.
   * @throws InvalidCoordinateException if the coordinate in the museum is invalid.
   */
  @Override
  public Museum createMuseum(Museum museum) {
    Boolean isCoordinateValid = CoordinateUtil.isCoordinateValid(museum.getCoordinate());
    if (!isCoordinateValid) {
      throw new InvalidCoordinateException();
    }
    return this.museumFakeDatabase.saveMuseum(museum);
  }

  /**
   * Retrieves a museum by its ID.
   *
   * @param id The ID of the museum to retrieve.
   * @return The museum with the specified ID.
   */
  @Override
  public Museum getMuseum(Long id) {
    // Implementation to be added.
    return null;
  }
}
