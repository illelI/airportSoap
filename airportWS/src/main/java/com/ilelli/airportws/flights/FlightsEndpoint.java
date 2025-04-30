package com.ilelli.airportws.flights;

import jakarta.transaction.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;
import java.util.List;

@Endpoint
class FlightsEndpoint {
    private static final String NAMESPACE = "http://ilelli.com/airport/flights";
    private final FlightsService flightsService;

    FlightsEndpoint(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "FlightsRequest")
    @ResponsePayload
    public FlightsResponse getFlights(@RequestPayload FlightsRequest request) {
        FlightsResponse response = new FlightsResponse();
        response.setFlights(List.of(new FlightDetails("jp2gmd", "wadowice", "watykan", LocalDate.now(), 2137),
                new FlightDetails("jd123", "warszawa", "ateny", LocalDate.MIN, 222)
                ));
        return response;
    }
}
