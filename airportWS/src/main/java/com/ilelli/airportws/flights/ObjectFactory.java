package com.ilelli.airportws.flights;

import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.JAXBElement;

import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private static final QName FLIGHTS_REQUEST_QNAME = new QName("http://ilelli.com/airport/flights", "FlightsRequest");
    private static final QName FLIGHTS_RESPONSE_QNAME = new QName("http://ilelli.com/airport/flights", "FlightsResponse");

    public ObjectFactory() {
    }

    public FlightsRequest createFlightsRequest() {
        return new FlightsRequest();
    }

    public FlightsResponse createFlightsResponse() {
        return new FlightsResponse();
    }

    public FlightDetails createFlightDetails() {
        return new FlightDetails();
    }

    public JAXBElement<FlightsRequest> createFlightsRequest(FlightsRequest value) {
        return new JAXBElement<>(FLIGHTS_REQUEST_QNAME, FlightsRequest.class, null, value);
    }

    public JAXBElement<FlightsResponse> createFlightsResponse(FlightsResponse value) {
        return new JAXBElement<>(FLIGHTS_RESPONSE_QNAME, FlightsResponse.class, null, value);
    }
}
