package com.ilelli.airportws.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ticket"
})
@XmlRootElement(name = "TicketsResponse", namespace = "http://ilelli.com/airport/user")
@Getter
@Setter
@NoArgsConstructor
public class TicketsResponse {
    @XmlElement(namespace = "http://ilelli.com/airport/user", name = "ticket")
    private List<TicketDetails> ticket;
}
