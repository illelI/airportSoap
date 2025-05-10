package com.ilelli.airportws.shared;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "SeatClass")
@XmlEnum
public enum SeatClass {
    @XmlEnumValue("ECONOMY")
    ECONOMY,
    @XmlEnumValue("BUSINESS")
    BUSINESS,
    @XmlEnumValue("FIRST")
    FIRST
}
