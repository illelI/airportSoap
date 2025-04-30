package com.ilelli.airportws.booking;

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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String passengerName;
    private String passengerSurname;
    private String flightNumber;
    private LocalDateTime departureDate;
    private SeatClass seatClass;
}
