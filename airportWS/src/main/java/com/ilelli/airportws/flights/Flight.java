package com.ilelli.airportws.flights;

import com.ilelli.airportws.shared.SeatClass;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String flightNumber;
    private String from;
    private String to;
    private LocalDateTime date;
    private SeatClass seatClass;
    private int price;
}
