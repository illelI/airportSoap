package com.ilelli.airportws.flights;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
        response.setFlights(flightsService.findFlights(request.getFrom(), request.getTo(), request.getDate(), request.getSeatClass()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "AllFlightsRequest")
    @ResponsePayload
    public AllFlightsResponse getAllFlights(@RequestPayload AllFlightsRequest request) {
        AllFlightsResponse response = new AllFlightsResponse();
        response.setFlights(flightsService.findAllFlights());
        return response;
    }
}
