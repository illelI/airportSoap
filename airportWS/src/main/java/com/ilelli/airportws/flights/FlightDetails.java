package com.ilelli.airportws.flights;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class FlightDetails {
    private String flightNumber;
    private String from;
    private String to;
    private LocalDate date;
    private int price;
}
