package com.ilelli.airportws.user;

import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.Set;

public class UserAuthenticator implements SOAPHandler<SOAPMessageContext> {
    private final UserService userService;

    public UserAuthenticator(UserService userService) {
        this.userService = userService;
    }


    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext soapMessageContext) {
        return false;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        return false;
    }

    @Override
    public void close(MessageContext messageContext) {

    }
}
