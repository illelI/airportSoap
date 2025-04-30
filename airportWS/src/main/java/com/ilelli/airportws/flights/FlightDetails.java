package com.ilelli.airportws.flights;

import com.ilelli.airportws.shared.DateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightDetails", propOrder = { "flightNumber", "from", "to", "date", "price" })
@Data
@AllArgsConstructor
public class FlightDetails {
    private String flightNumber;
    private String from;
    private String to;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate date;
    private int price;
}
