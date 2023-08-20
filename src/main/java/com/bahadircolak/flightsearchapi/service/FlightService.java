package com.bahadircolak.flightsearchapi.service;

import com.bahadircolak.flightsearchapi.model.Flight;
import com.bahadircolak.flightsearchapi.repository.FlightRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        flight.setId(id);
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> getAllFlights() {
        return (List<Flight>) flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found with id: " + id));
    }

    public List<Flight> searchOneWayFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDate) {
        return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTimeGreaterThanEqual(
                departureAirport, arrivalAirport, departureDate);
    }

    public List<Flight> searchRoundTripFlights(String departureAirport, String arrivalAirport,
                                               LocalDateTime departureDate, LocalDateTime arrivalDate) {
        return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTimeBetween(
                departureAirport, arrivalAirport, departureDate, arrivalDate);
    }
}
