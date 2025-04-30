package com.ilelli.airportws.booking;

import jakarta.transaction.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
class BookingEndpoint {
    private static final String NAMESPACE = "http://ilelli.com/airport/booking";
    private final BookingService bookingService;

    public BookingEndpoint(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Transactional
    @PayloadRoot(namespace = NAMESPACE, localPart = "BookingRequest")
    @ResponsePayload
    public BookingResponse book(@RequestPayload BookingRequest request) {
        BookingResponse response = new BookingResponse();
        try {
            bookingService.book(request);
            response.setStatus(BookingStatus.CONFIRMED);
        } catch (Exception e) {
            response.setStatus(BookingStatus.FAILED);
        }
        return response;
    }
}
