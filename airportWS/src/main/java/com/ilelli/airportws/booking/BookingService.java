package com.ilelli.airportws.booking;

import com.ilelli.airportws.shared.SeatClass;
import com.ilelli.airportws.shared.Ticket;
import com.ilelli.airportws.shared.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class BookingService {

    private final TicketRepository ticketRepository;

    BookingService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    void book(String passengerName, String passengerSurname, String flightNumber, LocalDateTime departureDate, SeatClass seatClass) {
        Ticket ticket = new Ticket();
        ticket.setPassengerName(passengerName);
        ticket.setPassengerSurname(passengerSurname);
        ticket.setFlightNumber(flightNumber);
        ticket.setDepartureDate(departureDate);
        ticket.setSeatClass(seatClass);
        ticketRepository.save(ticket);
    }

}
