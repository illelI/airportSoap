package com.ilelli.airportws.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ticketDetails"
})
@XmlRootElement(name = "TicketPdfRequest", namespace = "http://ilelli.com/airport/user")
@Getter
@Setter
class TicketPdfRequest {
    private TicketDetails ticketDetails;
}
