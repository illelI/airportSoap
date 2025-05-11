package com.ilelli.airportws.flights;

import com.ilelli.airportws.shared.SeatClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
interface FlightsRepository extends JpaRepository<Flight, UUID> {
    List<Flight> findAllByDepartureAndDestinationAndSeatClassAndDateAfterAndDateBefore(String from, String to, SeatClass seatClass, LocalDateTime dateTime, LocalDateTime maxDate);
    List<Flight> findAllByDateAfterAndDateBefore(LocalDateTime date, LocalDateTime ddd);
    List<Flight> findAllByDepartureAndDestinationAndSeatClass(String from, String to, SeatClass seatClass);
}
