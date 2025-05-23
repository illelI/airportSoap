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
        "username",
        "password"
})
@XmlRootElement(name = "LoginRequest", namespace = "http://ilelli.com/airport/user")
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String username;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String password;
}
