package com.bahadircolak.flightsearchapi.scheduledJob;

import com.bahadircolak.flightsearchapi.model.Flight;
import com.bahadircolak.flightsearchapi.service.FlightService;
import com.bahadircolak.flightsearchapi.scheduledJob.MockFlightApiService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightDataUpdater {

    private final MockFlightApiService mockFlightApiService;
    private final FlightService flightService;

    public FlightDataUpdater(MockFlightApiService mockFlightApiService, FlightService flightService) {
        this.mockFlightApiService = mockFlightApiService;
        this.flightService = flightService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateFlightData() {
        List<Flight> mockFlights = mockFlightApiService.getMockFlights();

        for (Flight mockFlight : mockFlights) {
            flightService.addFlight(mockFlight);
        }

        System.out.println("Flight data update completed.");
    }
}

