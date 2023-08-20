package com.bahadircolak.flightsearchapi.scheduledJob;

import com.bahadircolak.flightsearchapi.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MockFlightApiService {

    public List<Flight> getMockFlights() {

        List<Flight> mockFlights = new ArrayList<>();

        Flight flight1 = new Flight();
        flight1.setDepartureAirport("IST");
        flight1.setArrivalAirport("JFK");
        flight1.setDepartureDateTime(LocalDateTime.now().plusHours(1));
        flight1.setArrivalDateTime(LocalDateTime.now().plusHours(10));
        flight1.setPrice(500.0);
        mockFlights.add(flight1);

        Flight flight2 = new Flight();
        flight2.setDepartureAirport("DOH");
        flight2.setArrivalAirport("LHR");
        flight2.setDepartureDateTime(LocalDateTime.now().plusHours(3));
        flight2.setArrivalDateTime(LocalDateTime.now().plusHours(12));
        flight2.setPrice(600.0);
        mockFlights.add(flight2);


        return mockFlights;
    }
}



