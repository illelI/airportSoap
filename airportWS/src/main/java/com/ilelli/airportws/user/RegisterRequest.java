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
        "password",
        "name",
        "surname"
})
@XmlRootElement(name = "RegisterRequest", namespace = "http://ilelli.com/airport/user")
@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String username;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String password;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String name;
    @XmlElement(namespace = "http://ilelli.com/airport/user")
    private String surname;
}
