package com.ilelli.airportws.config;

import com.ilelli.airportws.user.UserAuthenticator;
import com.ilelli.airportws.user.UserService;
import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPConstants;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public SaajSoapMessageFactory messageFactory() throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SaajSoapMessageFactory saajSoapMessageFactory = new SaajSoapMessageFactory(messageFactory);
        saajSoapMessageFactory.afterPropertiesSet();
        return saajSoapMessageFactory;
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext ctx) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(ctx);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public UserAuthenticator authenticationInterceptor(UserService userService) {
        return new UserAuthenticator(userService);
    }

    @Bean
    public EndpointInterceptor[] endpointInterceptors(UserAuthenticator userAuthenticator) {
        return new EndpointInterceptor[] { userAuthenticator };
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths(
                "com.ilelli.airportws.booking"
                //"com.ilelli.airportws.flights",
                //"com.ilelli.airportws.user"
        );
        return marshaller;
    }


    @Bean(name = "booking")
    public DefaultWsdl11Definition bookingWsdl11Definition(@Qualifier("bookingSchema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("BookingPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://ilelli.com/airport/booking");
        wsdl.setSchema(schema);
        return wsdl;
    }

    @Bean
    public XsdSchema bookingSchema() {
        return new SimpleXsdSchema(new ClassPathResource("static/xsd/booking.xsd"));
    }

    @Bean(name = "flights")
    public DefaultWsdl11Definition flightsWsdl11Definition(@Qualifier("flightsSchema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("FlightsPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://ilelli.com/airport/flights");
        wsdl.setSchema(schema);
        return wsdl;
    }

    @Bean
    public XsdSchema flightsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("static/xsd/flights.xsd"));
    }

    @Bean(name = "user")
    public DefaultWsdl11Definition userWsdl11Definition(@Qualifier("userSchema") XsdSchema schema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("UserPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://ilelli.com/airport/user");
        wsdl.setSchema(schema);
        return wsdl;
    }

    @Bean
    public XsdSchema userSchema() {
        return new SimpleXsdSchema(new ClassPathResource("static/xsd/user.xsd"));
    }
}
