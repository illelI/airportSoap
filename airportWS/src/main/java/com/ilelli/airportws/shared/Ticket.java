package com.ilelli.airportws.shared;

import com.ilelli.airportws.user.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String departure;
    private String destination;
    private LocalDateTime departureDate;
    private SeatClass seatClass;

    @ManyToOne
    @JoinColumn(name = "user_id") // FK w tabeli Ticket
    private Users user;
}
