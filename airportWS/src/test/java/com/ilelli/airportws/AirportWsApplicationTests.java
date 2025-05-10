package com.ilelli.airportws;

import com.ilelli.airportws.booking.BookingRequest;
import jakarta.xml.bind.JAXBElement;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AirportWsApplicationTests {

	@Test
	void contextLoads() {
	}
}
