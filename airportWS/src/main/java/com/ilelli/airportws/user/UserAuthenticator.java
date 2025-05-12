package com.ilelli.airportws.user;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import java.util.Iterator;

public class UserAuthenticator implements EndpointInterceptor {
    private final UserService userService;

    public UserAuthenticator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {
        SoapMessage soapMessage = (SoapMessage) messageContext.getRequest();
        SoapBody body = soapMessage.getSoapBody();

        // Pobieramy pierwszy element w body - to jest element operacji
        Node operationElement = body.getPayloadSource() instanceof DOMSource
                ? ((DOMSource) body.getPayloadSource()).getNode()
                : null;

        if (operationElement != null && operationElement instanceof Element) {
            String operationName = ((Element) operationElement).getLocalName();
            System.out.println("Operation name: " + operationName);

            if ("registerrequest".equalsIgnoreCase(operationName)) {
                return true;
            }
        }
        SoapHeader header = soapMessage.getSoapHeader();

        if (header == null) {
            return false;
        }

        Iterator<SoapHeaderElement> it = header.examineAllHeaderElements();

        String login = null;
        String password = null;

        while (it.hasNext()) {
            SoapHeaderElement element = it.next();
            Source source = element.getSource();

            if (source instanceof DOMSource) {
                Node node = ((DOMSource) source).getNode();
                if (node instanceof Element) {
                    Element el = (Element) node;
                    String localName = el.getLocalName();
                    String value = el.getTextContent();


                    if ("login".equalsIgnoreCase(localName)) {
                        login = value;
                    } else if ("password".equalsIgnoreCase(localName)) {
                        password = value;
                    }
                }
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
