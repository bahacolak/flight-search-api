package com.bahadircolak.flightsearchapi.controller;

import com.bahadircolak.flightsearchapi.model.Flight;
import com.bahadircolak.flightsearchapi.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Api(value = "Flight Management System", description = "Operations related to flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @ApiOperation(value = "Add a new flight")
    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight addedFlight = flightService.addFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedFlight);
    }

    @ApiOperation(value = "Get a flight by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);
        return ResponseEntity.ok(flight);
    }

    @ApiOperation(value = "Get all flights")
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }


    @ApiOperation(value = "Update a flight by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Flight updatedFlight = flightService.updateFlight(id, flight);
        return ResponseEntity.ok(updatedFlight);
    }

    @ApiOperation(value = "Delete a flight by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}

