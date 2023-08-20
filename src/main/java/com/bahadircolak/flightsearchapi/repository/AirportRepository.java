package com.bahadircolak.flightsearchapi.repository;

import com.bahadircolak.flightsearchapi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
