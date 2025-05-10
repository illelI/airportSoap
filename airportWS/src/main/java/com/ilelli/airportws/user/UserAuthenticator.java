package com.ilelli.airportws.user;

import jakarta.xml.soap.Node;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.soap.SOAPHeaderElement;
import jakarta.xml.soap.SOAPMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.namespace.QName;
import java.util.Iterator;

public class UserAuthenticator implements EndpointInterceptor {
    private final UserService userService;

    public UserAuthenticator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {
        QName operation = (QName) messageContext.getProperty("javax.xml.ws.wsdl.operation");
        if (operation != null && "register".equalsIgnoreCase(operation.getLocalPart())) {
            return true;
        }

        SoapMessage soapMessage = (SoapMessage) messageContext.getRequest();
        SoapHeader header = soapMessage.getSoapHeader();

        if (header == null) {
            return false;
        }

        Iterator<?> it = header.examineAllHeaderElements();

        String login = null;
        String password = null;

        while (it.hasNext()) {
            Node node = (Node) it.next();
            String localName = node.getLocalName();
            String value = node.getValue();

            if ("login".equalsIgnoreCase(localName)) {
                login = value;
            } else if ("password".equalsIgnoreCase(localName)) {
                password = value;
            }
        }

        if (login == null || password == null) {
            return false;
        }

        return userService.checkUser(login, password);
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object o) throws Exception {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object o) throws Exception {
        return false;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) throws Exception {

    }
}
