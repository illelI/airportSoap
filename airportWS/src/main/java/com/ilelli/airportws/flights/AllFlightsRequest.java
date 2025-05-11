package com.ilelli.airportws.flights;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
})
@XmlRootElement(name = "AllFlightsRequest", namespace = "http://ilelli.com/airport/flights")
@NoArgsConstructor
public class AllFlightsRequest {
}
