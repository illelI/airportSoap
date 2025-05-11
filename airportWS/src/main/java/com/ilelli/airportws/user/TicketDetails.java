package com.ilelli.airportws.user;

import com.ilelli.airportws.shared.LocalDateTimeAdapter;
import com.ilelli.airportws.shared.SeatClass;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketDetails", propOrder = {"id", "passengerName", "passengerSurname","departure", "destination", "flightNumber", "departureDate", "seatClass" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDetails {
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String id;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String passengerName;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String passengerSurname;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String departure;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String destination;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String flightNumber;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime departureDate;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private SeatClass seatClass;
}
