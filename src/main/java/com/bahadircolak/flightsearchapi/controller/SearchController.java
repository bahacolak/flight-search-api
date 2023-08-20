package com.bahadircolak.flightsearchapi.controller;

import com.bahadircolak.flightsearchapi.model.Flight;
import com.bahadircolak.flightsearchapi.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final FlightService flightService;

    public SearchController(FlightService flightService) {
        this.flightService = flightService;
    }


    @GetMapping
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam("departure") String departureAirport,
            @RequestParam("arrival") String arrivalAirport,
            @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDate,
            @RequestParam(value = "arrivalDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime arrivalDate) {

        List<Flight> flights;

        if (arrivalDate != null) {

            flights = flightService.searchRoundTripFlights(departureAirport, arrivalAirport, departureDate, arrivalDate);
        } else {

            flights = flightService.searchOneWayFlights(departureAirport, arrivalAirport, departureDate);
        }

        return ResponseEntity.ok(flights);
    }

}
