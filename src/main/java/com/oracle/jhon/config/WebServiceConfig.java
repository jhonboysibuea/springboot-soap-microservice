package com.oracle.jhon.config;

import com.oracle.jhon.controller.SoapEndpoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.endpoint.adapter.DefaultMethodEndpointAdapter;
import org.springframework.ws.server.endpoint.mapping.PayloadRootQNameEndpointMapping;
import org.springframework.ws.server.endpoint.mapping.UriEndpointMapping;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs

public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }
    @Bean
    public UriEndpointMapping uriEndpointMapping() {
        UriEndpointMapping uriEndpointMapping = new UriEndpointMapping();
        uriEndpointMapping.setDefaultEndpoint(soapEndpoint());
        return uriEndpointMapping;
    }

    @Bean
    public PayloadRootQNameEndpointMapping payloadRootQNameEndpointMapping() {
        PayloadRootQNameEndpointMapping mapping = new PayloadRootQNameEndpointMapping();
        mapping.setDefaultEndpoint(soapEndpoint());
        return mapping;
    }

    @Bean
    public SoapEndpoint soapEndpoint() {
        return new SoapEndpoint();
    }

    @Bean
    public DefaultMethodEndpointAdapter defaultMethodEndpointAdapter() {
        return new DefaultMethodEndpointAdapter();
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema sampleSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("SampleServicePort");
        definition.setTargetNamespace("http://www.oracle.com/external/services/sampleservice/request/v1.0");
        definition.setLocationUri("/external/services/ws");
        definition.setSchema(sampleSchema);
        return definition;
    }

    @Bean
    public XsdSchema sampleSchema() {
        return new SimpleXsdSchema(new ClassPathResource("sample.xsd"));
    }

}
