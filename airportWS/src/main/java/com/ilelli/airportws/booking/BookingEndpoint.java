package com.ilelli.airportws.booking;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookingEndpoint {
    private static final String NAMESPACE = "http://ilelli.com/airport/booking";

    @PayloadRoot(namespace = NAMESPACE, localPart = "BookingRequest")
    @ResponsePayload
    public BookingResponse book(@RequestPayload BookingRequest request) {
        BookingResponse response = new BookingResponse();
        try {
            response.setStatus(BookingStatus.CONFIRMED);
        } catch (Exception e) {
            response.setStatus(BookingStatus.FAILED);
        }
        return response;
    }
}
