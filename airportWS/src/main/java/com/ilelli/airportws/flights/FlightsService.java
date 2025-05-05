package com.ilelli.airportws.flights;

import com.ilelli.airportws.shared.SeatClass;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
class FlightsService {
    //private final FlightsRepository flightsRepository;

    //public FlightsService(FlightsRepository flightsRepository) {
    //    this.flightsRepository = flightsRepository;
   // }

    public List<FlightDetails> findFlights(String from, String to, LocalDateTime departureDate, SeatClass seatClass) {
        List<Flight> flights = new ArrayList<>();
        //List<Flight> flights = flightsRepository.get();
        return flights.stream().map(this::flightToFlightDetailsMapper).collect(Collectors.toList());
    }

    private FlightDetails flightToFlightDetailsMapper(Flight flight) {
        return new FlightDetails(flight.getFlightNumber(), flight.getFrom(), flight.getTo(), flight.getDate(), flight.getPrice());
    }
}
