package com.ilelli.airportws;

import com.ilelli.airportws.user.LoginRequest;
import com.ilelli.airportws.user.LoginResponse;
import com.ilelli.airportws.user.ObjectFactory;
import com.ilelli.airportws.user.RegisterRequest;
import com.ilelli.airportws.user.TicketDetails;
import com.ilelli.airportws.user.TicketPdfRequest;
import com.ilelli.airportws.user.TicketPdfResponse;
import com.ilelli.airportws.user.TicketsRequest;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportWsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirportWsApplication.class, args);
	}
}
