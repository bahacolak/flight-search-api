package com.bahadircolak.flightsearchapi.repository;

import com.bahadircolak.flightsearchapi.model.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeGreaterThanEqual(
            String departureAirport, String arrivalAirport, LocalDateTime departureDateTime);

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeBetween(
            String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime);

}


