package com.ilelli.airportws.flights;

import com.ilelli.airportws.shared.SeatClass;
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
        "flightNumber",
        "from",
        "to",
        "date",
        "seatClass"
})
@XmlRootElement(name = "FlightsRequest", namespace = "http://ilelli.com/airport/flights")
@Getter
@Setter
class FlightsRequest {
    private String flightNumber;
    private String from;
    private String to;
    @XmlSchemaType(name = "date")
    private LocalDate date;
    private SeatClass seatClass;
}
