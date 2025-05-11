package com.ilelli.airportws.flights;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "flights"
})
@XmlRootElement(name = "FlightsResponse", namespace = "http://ilelli.com/airport/flights")
@Getter
@Setter
@NoArgsConstructor
public class FlightsResponse {
    @XmlElement(namespace = "http://ilelli.com/airport/flights", name = "flight")
    private List<FlightDetails> flights;
}
