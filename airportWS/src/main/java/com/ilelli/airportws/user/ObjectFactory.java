package com.ilelli.airportws.user;

import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName REGISTER_REQUEST_QNAME = new QName("http://ilelli.com/airport/user", "RegisterRequest");
    private static final QName LOGIN_REQUEST_QNAME = new QName("http://ilelli.com/airport/user", "LoginRequest");
    private static final QName TICKETS_REQUEST_QNAME = new QName("http://ilelli.com/airport/user", "TicketsRequest");
    private static final QName TICKET_PDF_REQUEST_QNAME = new QName("http://ilelli.com/airport/user", "TicketPdfRequest");
    private static final QName LOGIN_RESPONSE_QNAME = new QName("http://ilelli.com/airport/user", "LoginResponse");
    private static final QName REGISTER_RESPONSE_QNAME = new QName("http://ilelli.com/airport/user", "RegisterResponse");
    private static final QName TICKETS_RESPONSE_QNAME = new QName("http://ilelli.com/airport/user", "TicketsResponse");
    private static final QName TICKET_PDF_RESPONSE_QNAME = new QName("http://ilelli.com/airport/user", "TicketPdfResponse");

    public ObjectFactory() {
    }

    public RegisterRequest createRegisterRequest() {
        return new RegisterRequest();
    }

    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    public TicketsRequest createTicketsRequest() {
        return new TicketsRequest();
    }

    public TicketPdfRequest createTicketPdfRequest() {
        return new TicketPdfRequest();
    }

    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    public TicketsResponse createTicketsResponse() {
        return new TicketsResponse();
    }

    public TicketPdfResponse createTicketPdfResponse() {
        return new TicketPdfResponse();
    }

    public TicketDetails createTicketDetails() {
        return new TicketDetails();
    }

    public JAXBElement<RegisterRequest> createRegisterRequest(RegisterRequest value) {
        return new JAXBElement<>(REGISTER_REQUEST_QNAME, RegisterRequest.class, null, value);
    }

    public JAXBElement<LoginRequest> createLoginRequest(LoginRequest value) {
        return new JAXBElement<>(LOGIN_REQUEST_QNAME, LoginRequest.class, null, value);
    }

    public JAXBElement<TicketsRequest> createTicketsRequest(TicketsRequest value) {
        return new JAXBElement<>(TICKETS_REQUEST_QNAME, TicketsRequest.class, null, value);
    }

    public JAXBElement<TicketPdfRequest> createTicketPdfRequest(TicketPdfRequest value) {
        return new JAXBElement<>(TICKET_PDF_REQUEST_QNAME, TicketPdfRequest.class, null, value);
    }

    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<>(LOGIN_RESPONSE_QNAME, LoginResponse.class, null, value);
    }

    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<>(REGISTER_RESPONSE_QNAME, RegisterResponse.class, null, value);
    }

    public JAXBElement<TicketsResponse> createTicketsResponse(TicketsResponse value) {
        return new JAXBElement<>(TICKETS_RESPONSE_QNAME, TicketsResponse.class, null, value);
    }

    public JAXBElement<TicketPdfResponse> createTicketPdfResponse(TicketPdfResponse value) {
        return new JAXBElement<>(TICKET_PDF_RESPONSE_QNAME, TicketPdfResponse.class, null, value);
    }
}
