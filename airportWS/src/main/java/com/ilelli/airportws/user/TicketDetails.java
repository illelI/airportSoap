package com.ilelli.airportws.user;

import com.ilelli.airportws.shared.SeatClass;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightDetails", propOrder = { "passengerName", "passengerSurname", "flightNumber", "departureDate", "seatClass" })
@Data
@AllArgsConstructor
class TicketDetails {
    private String passengerName;
    private String passengerSurname;
    private String flightNumber;
    private LocalDateTime departureDate;
    private SeatClass seatClass;
}
