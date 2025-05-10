package com.ilelli.airportws.user;

import jakarta.activation.DataHandler;
import jakarta.transaction.Transactional;
import jakarta.xml.ws.soap.MTOM;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@MTOM
class UserEndpoint {
    private static final String NAMESPACE = "http://ilelli.com/airport/user";
    private final UserService userService;

    UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    @PayloadRoot(namespace = NAMESPACE, localPart = "RegisterRequest")
    @ResponsePayload
    public RegisterResponse registerUser(@RequestPayload RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        response.setId(userService.register(request));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "LoginRequest")
    @ResponsePayload
    public LoginResponse login(@RequestPayload LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.setId(userService.login(request.getUsername(), request.getPassword()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getTickets")
    @ResponsePayload
    public TicketsResponse getUserTickets(@RequestPayload TicketsRequest request) {
        TicketsResponse ticketsResponse = new TicketsResponse();
        return ticketsResponse;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getTicketPdf")
    @ResponsePayload
    public DataHandler getTicketPdf(@RequestPayload TicketPdfRequest request) {
        try {
            return new DataHandler(userService.getTicketPdf(request.getTicketDetails()), "application/pdf");
        } catch (Exception e) {
            return null;
        }
    }

}
