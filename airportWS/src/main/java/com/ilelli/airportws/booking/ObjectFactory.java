package com.ilelli.airportws.booking;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class ObjectFactory {

    private final static QName _BookingRequest_QNAME = new QName("http://ilelli.com/airport/booking", "BookingRequest");
    private final static QName _BookingResponse_QNAME = new QName("http://ilelli.com/airport/booking", "BookingResponse");

    public ObjectFactory() {
    }

    public BookingRequest createBookingRequest() {
        return new BookingRequest();
    }

    public BookingResponse createBookingResponse() {
        return new BookingResponse();
    }

    public JAXBElement<BookingRequest> createBookingRequest(BookingRequest value) {
        return new JAXBElement<BookingRequest>(_BookingRequest_QNAME, BookingRequest.class, null, value);
    }

    public JAXBElement<BookingResponse> createBookingResponse(BookingResponse value) {
        return new JAXBElement<BookingResponse>(_BookingResponse_QNAME, BookingResponse.class, null, value);
    }
}
