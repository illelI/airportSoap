package com.ilelli.airportws.flights;

import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.JAXBElement;

import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private static final QName FLIGHTS_REQUEST_QNAME = new QName("http://ilelli.com/airport/flights", "FlightsRequest");
    private static final QName FLIGHTS_RESPONSE_QNAME = new QName("http://ilelli.com/airport/flights", "FlightsResponse");
    private static final QName ALL_FLIGHTS_REQUEST_QNAME = new QName("http://ilelli.com/airport/flights", "AllFlightsRequest");
    private static final QName ALL_FLIGHTS_RESPONSE_QNAME = new QName("http://ilelli.com/airport/flights", "AllFlightsResponse");

    public ObjectFactory() {
    }

    public FlightsRequest createFlightsRequest() {
        return new FlightsRequest();
    }

    public FlightsResponse createFlightsResponse() {
        return new FlightsResponse();
    }

    public AllFlightsRequest createAllFlightsRequest() {
        return new AllFlightsRequest();
    }

    public AllFlightsResponse createAllFlightsResponse() {
        return new AllFlightsResponse();
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

    public JAXBElement<AllFlightsRequest> createAllFlightsRequest(AllFlightsRequest value) {
        return new JAXBElement<>(ALL_FLIGHTS_REQUEST_QNAME, AllFlightsRequest.class, null, value);
    }

    public JAXBElement<AllFlightsResponse> createAllFlightsResponse(AllFlightsResponse value) {
        return new JAXBElement<>(ALL_FLIGHTS_RESPONSE_QNAME, AllFlightsResponse.class, null, value);
    }
}
