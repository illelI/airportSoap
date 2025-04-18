package com.ilelli.airportws.booking;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "reservationCode",
        "status"
})
@XmlRootElement(name = "BookingResponse", namespace = "http://ilelli.com/airport/booking")
@Getter
@Setter
public class BookingResponse {
    private String reservationCode;
    private BookingStatus status;
}
