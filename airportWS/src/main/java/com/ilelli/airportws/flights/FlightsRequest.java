package com.ilelli.airportws.flights;

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
        "from",
        "to",
        "date",
        "seatClass"
})
@XmlRootElement(name = "FlightsRequest", namespace = "http://ilelli.com/airport/flights")
@Getter
@Setter
@NoArgsConstructor
public class FlightsRequest {
    @XmlElement(namespace = "http://ilelli.com/airport/flight")
    private String from;
    @XmlElement(namespace = "http://ilelli.com/airport/flight")
    private String to;
    @XmlElement(namespace = "http://ilelli.com/airport/flight")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "date")
    private LocalDateTime date;
    @XmlElement(namespace = "http://ilelli.com/airport/flight")
    private SeatClass seatClass;
}
