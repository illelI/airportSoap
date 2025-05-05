package com.ilelli.airportws.flights;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightDetails", propOrder = { "flightNumber", "from", "to", "date", "price" })
@Data
@AllArgsConstructor
public class FlightDetails {
    private String flightNumber;
    private String from;
    private String to;
    private LocalDateTime date;
    private int price;
}
