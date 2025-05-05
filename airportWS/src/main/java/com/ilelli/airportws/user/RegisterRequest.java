package com.ilelli.airportws.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
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
class RegisterRequest {
    private String username;
    private String password;
    private String name;
    private String surname;
}
