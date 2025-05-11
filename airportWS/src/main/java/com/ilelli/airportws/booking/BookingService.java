package com.ilelli.airportws.booking;

import com.ilelli.airportws.shared.SeatClass;
import com.ilelli.airportws.shared.Ticket;
import com.ilelli.airportws.shared.TicketRepository;
import com.ilelli.airportws.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class BookingService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    BookingService(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    void book(String passengerName, String passengerSurname, String flightNumber, String from, String to ,LocalDateTime departureDate, SeatClass seatClass) {
        Ticket ticket = new Ticket();
        ticket.setPassengerName(passengerName);
        ticket.setPassengerSurname(passengerSurname);
        ticket.setFlightNumber(flightNumber);
        ticket.setDeparture(from);
        ticket.setDestination(to);
        ticket.setDepartureDate(departureDate);
        ticket.setSeatClass(seatClass);
        ticket.setUser(userRepository.findFirstByNameAndSurname(passengerName, passengerSurname));
        ticketRepository.save(ticket);
    }

}
