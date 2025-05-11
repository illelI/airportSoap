package com.ilelli.airportws.flights;

import com.ilelli.airportws.shared.SeatClass;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
class FlightGenerator {

    private final FlightsRepository flightsRepository;

    private final List<String> cities = Arrays.asList(
            "Warszawa", "Kraków", "Gdańsk", "Wrocław", "Poznań", "Szczecin",
            "Katowice", "Lublin", "Rzeszów", "Łódź", "Bydgoszcz", "Białystok"
    );

    private final Random random = new Random();

    FlightGenerator(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    @PostConstruct
    public void generateFlights() {
        if (flightsRepository.count() > 0) {
            return;
        }

        int flightCountPerClass = 33;

        for (SeatClass seatClass : SeatClass.values()) {
            for (int i = 0; i < flightCountPerClass; i++) {
                String departure = getRandomCity();
                String destination = getRandomCityDifferentFrom(departure);

                Flight flight = new Flight();
                flight.setFlightNumber(generateFlightNumber());
                flight.setDeparture(departure);
                flight.setDestination(destination);
                flight.setDate(generateRandomDate());
                flight.setSeatClass(seatClass);
                flight.setPrice(generateRandomPrice(seatClass));

                flightsRepository.save(flight);
            }
        }

        System.out.println("Generated flights");
    }

    private String getRandomCity() {
        return cities.get(random.nextInt(cities.size()));
    }

    private String getRandomCityDifferentFrom(String city) {
        String other;
        do {
            other = getRandomCity();
        } while (other.equals(city));
        return other;
    }

    private String generateFlightNumber() {
        char first = (char) ('A' + random.nextInt(26));
        char second = (char) ('A' + random.nextInt(26));
        int number = 100 + random.nextInt(900);
        return "" + first + second + number;
    }

    private LocalDateTime generateRandomDate() {
        int daysAhead = random.nextInt(30); // najbliższe 30 dni
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        return LocalDateTime.now().plusDays(daysAhead).withHour(hour).withMinute(minute).withSecond(0).withNano(0);
    }

    private int generateRandomPrice(SeatClass seatClass) {
        return switch (seatClass) {
            case ECONOMY -> 200 + random.nextInt(200);
            case BUSINESS -> 500 + random.nextInt(300);
            case FIRST -> 1000 + random.nextInt(500);
        };
    }
}
