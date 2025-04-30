package com.ilelli.airportws.booking;

import org.springframework.stereotype.Service;

@Service
class BookingService {
    //private final BookingRepository bookingRepository;

    //public BookingService(BookingRepository bookingRepository) {
    //    this.bookingRepository = bookingRepository;
    //}

    void book(BookingRequest request) {
        //bookingRepository.save(requestToTicket(request));
    }

    private Ticket requestToTicket(BookingRequest request) {
        Ticket ticket = new Ticket();
        ticket.setDepartureDate(request.getDepartureDate());
        ticket.setFlightNumber(request.getFlightNumber());
        ticket.setSeatClass(request.getSeatClass());
        ticket.setPassengerName(request.getPassengerName());
        ticket.setPassengerSurname(request.getPassengerSurname());
        return ticket;
    }

}
