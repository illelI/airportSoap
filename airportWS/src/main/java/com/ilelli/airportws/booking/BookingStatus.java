package com.ilelli.airportws.booking;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "BookingStatus")
@XmlEnum
public enum BookingStatus {
    CONFIRMED,
    FAILED
}
