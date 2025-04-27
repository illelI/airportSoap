package com.ilelli.airportws;

import com.ilelli.airportws.flights.FlightDetails;
import jakarta.xml.ws.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.namespace.QName;
import java.net.URL;

@SpringBootApplication
public class AirportWsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirportWsApplication.class, args);

	}
}
