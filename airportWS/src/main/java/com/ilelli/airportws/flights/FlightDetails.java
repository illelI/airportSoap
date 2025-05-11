package com.ilelli.airportws.flights;

import com.ilelli.airportws.shared.LocalDateTimeAdapter;
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
@XmlType(name = "FlightDetails", propOrder = { "flightNumber", "from", "to", "date", "price" })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDetails {
    @XmlElement(namespace = "http://ilelli.com/airport/flights")
    private String flightNumber;
    @XmlElement(namespace = "http://ilelli.com/airport/flights")
    private String from;
    @XmlElement(namespace = "http://ilelli.com/airport/flights")
    private String to;
    @XmlElement(namespace = "http://ilelli.com/airport/flights")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime date;
    @XmlElement(namespace = "http://ilelli.com/airport/flights")
    private int price;
}
