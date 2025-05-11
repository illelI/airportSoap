package com.ilelli.airportws.user;

import com.ilelli.airportws.shared.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true)
    private String login;
    private String password;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ticket> tickets;
}
