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
        "result"
})
@XmlRootElement(name = "CheckTicketResponse", namespace = "http://ilelli.com/airport/user")
@Getter
@Setter
@NoArgsConstructor
public class CheckTicketResponse {
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private boolean result;
}