package com.ilelli.airportws.flights;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "flight"
})
@XmlRootElement(name = "FlightsResponse", namespace = "http://ilelli.com/airport/flights")
@Getter
@Setter
class FlightsResponse {
    private List<FlightDetails> flights;
}
