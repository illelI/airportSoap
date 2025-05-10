package com.ilelli.airportws.flights;

import com.ilelli.airportws.shared.SeatClass;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
class FlightsService {
    private final FlightsRepository flightsRepository;

    public FlightsService(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public List<FlightDetails> findFlights(String from, String to, LocalDateTime departureDate, SeatClass seatClass) {
        List<Flight> flights = flightsRepository.findAllByDepartureAndDestinationAndSeatClassAndDateAfterAndDateBefore(from, to, seatClass, departureDate, departureDate.plusDays(1));
        return flights.stream().map(this::flightToFlightDetailsMapper).toList();
    }

    private FlightDetails flightToFlightDetailsMapper(Flight flight) {
        return new FlightDetails(flight.getFlightNumber(), flight.getDeparture(), flight.getDestination(), flight.getDate(), flight.getPrice());
    }
}
