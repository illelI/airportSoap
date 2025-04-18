package com.ilelli.airportws.booking;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "passengerName",
        "flightNumber",
        "departureDate",
        "seatClass"
})
@XmlRootElement(name = "BookingRequest", namespace = "http://ilelli.com/airport/booking")
@Getter
@Setter
public class BookingRequest {
    private String passengerName;
    private String flightNumber;

    @XmlSchemaType(name = "date")
    private LocalDate departureDate;

    private SeatClass seatClass;
}
