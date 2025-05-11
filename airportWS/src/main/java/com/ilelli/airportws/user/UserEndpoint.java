package com.ilelli.airportws.user;

import jakarta.activation.DataHandler;
import jakarta.transaction.Transactional;
import jakarta.xml.ws.soap.MTOM;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
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
        RegisterResponse response = userService.register(request);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "LoginRequest")
    @ResponsePayload
    public LoginResponse login(@RequestPayload LoginRequest request) {
        LoginResponse response = userService.login(request.getUsername(), request.getPassword());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "TicketsRequest")
    @ResponsePayload
    public TicketsResponse getUserTickets(@RequestPayload TicketsRequest request) {
        TicketsResponse ticketsResponse = new TicketsResponse();
        ticketsResponse.setTicket(userService.getUserTickets(request.getUserId()));
        return ticketsResponse;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "TicketPdfRequest")
    @ResponsePayload
    @MTOM
    public TicketPdfResponse getTicketPdf(@RequestPayload TicketPdfRequest request) {
        try {
            TicketPdfResponse response = new TicketPdfResponse();
            System.out.println(request.getTicket().getId());
            byte[] pdfBytes = userService.getTicketPdf(request.getTicket());
            System.out.println("PDF bytes: " + (pdfBytes != null ? pdfBytes.length : "null"));
            response.setTicketPdf(pdfBytes);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "CheckTicketRequest")
    @ResponsePayload
    public CheckTicketResponse checkTicket(@RequestPayload CheckTicketRequest request) {
        CheckTicketResponse response = new CheckTicketResponse();
        response.setResult(userService.checkTicket(request.getTicketId()));
        return response;
    }
}
