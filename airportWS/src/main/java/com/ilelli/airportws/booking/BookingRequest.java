package com.ilelli.airportws.booking;

import com.ilelli.airportws.shared.SeatClass;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "passengerName",
        "passengerSurname",
        "flightNumber",
        "departureDate",
        "seatClass"
})
@XmlRootElement(name = "BookingRequest", namespace = "http://ilelli.com/airport/booking")
@Getter
@Setter
@NoArgsConstructor
public class BookingRequest {
    private String passengerName;
    private String passengerSurname;
    private String flightNumber;

    @XmlSchemaType(name = "date")
    private LocalDateTime departureDate;

    private SeatClass seatClass;
}
