package com.ilelli.airportws.booking;

import com.ilelli.airportws.shared.LocalDateTimeAdapter;
import com.ilelli.airportws.shared.SeatClass;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "passengerName",
        "passengerSurname",
        "flightNumber",
        "from",
        "to",
        "departureDate",
        "seatClass"
})
@XmlRootElement(name = "BookingRequest", namespace = "http://ilelli.com/airport/booking")
@Getter
@Setter
@NoArgsConstructor
public class BookingRequest {
    @XmlElement(namespace = "http://ilelli.com/airport/booking")
    private String passengerName;
    @XmlElement(namespace = "http://ilelli.com/airport/booking")
    private String passengerSurname;
    @XmlElement(namespace = "http://ilelli.com/airport/booking")
    private String flightNumber;
    @XmlElement(namespace = "http://ilelli.com/airport/booking")
    private String from;
    @XmlElement(namespace = "http://ilelli.com/airport/booking")
    private String to;
    @XmlElement(namespace = "http://ilelli.com/airport/booking")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime departureDate;
    @XmlElement(namespace = "http://ilelli.com/airport/booking")
    private SeatClass seatClass;
}
