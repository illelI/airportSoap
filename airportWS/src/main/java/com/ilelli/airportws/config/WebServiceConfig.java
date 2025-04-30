package com.ilelli.airportws.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext ctx) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(ctx);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
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
