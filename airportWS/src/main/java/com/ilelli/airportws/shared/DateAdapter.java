package com.ilelli.airportws.shared;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public LocalDate unmarshal(String string) {
        return string == null ? null : LocalDate.parse(string, formatter);
    }

    @Override
    public String marshal(LocalDate localDate) {
        return localDate == null ? null : localDate.format(formatter);
    }
}
