package com.ilelli.airportws.user;

import com.ilelli.airportws.booking.Ticket;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
class User {
    @Id
    private UUID id;
    private String login;
    private String password;
    private String name;
    private String surname;
    @OneToMany
    private List<Ticket> tickets;
}
