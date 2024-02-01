package com.betrybe.museumfinder.controller;


import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * museum controller.
 */

@RestController
@RequestMapping("/museums")
public class MuseumController {

  MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.service = museumService;
  }


  /**
   * museum post endpoint.
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumDto museum) {
    Museum newMuseum = ModelDtoConverter.dtoToModel(museum);
    MuseumDto res = ModelDtoConverter.modelToDto(this.service.createMuseum(newMuseum));
    return ResponseEntity.status(HttpStatus.CREATED).body(res);
  }

  /**
   * museum get closest endpoint.
   */

  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosest(
      @RequestParam(name = "lat") Double latitude,
      @RequestParam(name = "lng") Double longitude,
      @RequestParam(name = "max_dist_km") Double maxDistance
  ) {
    Coordinate newCoordinate = new Coordinate(latitude, longitude);
    Museum closestMuseum = this.service.getClosestMuseum(newCoordinate, maxDistance);
    MuseumDto response = ModelDtoConverter.modelToDto(closestMuseum);
    return ResponseEntity.ok(response);

  }

  ;
}
