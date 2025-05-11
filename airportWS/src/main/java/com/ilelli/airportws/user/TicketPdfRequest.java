package com.ilelli.airportws.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ticket"
})
@XmlRootElement(name = "TicketPdfRequest", namespace = "http://ilelli.com/airport/user")
@Getter
@Setter
@NoArgsConstructor
public class TicketPdfRequest {
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private TicketDetails ticket;
}
