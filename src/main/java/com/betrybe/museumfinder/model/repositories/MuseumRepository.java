package com.betrybe.museumfinder.model.repositories;

import com.betrybe.museumfinder.model.entities.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumRepository extends JpaRepository<Museum, Long> {

}
