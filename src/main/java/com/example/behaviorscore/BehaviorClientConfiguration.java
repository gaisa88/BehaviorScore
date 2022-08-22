package com.example.behaviorscore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
@Configuration
public class BehaviorClientConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.wsdl");
        return marshaller;
    }

    @Bean
    public BehaviorClient behaviorClient(Jaxb2Marshaller marshaller) {
        BehaviorClient client = new BehaviorClient();
        client.setDefaultUri("http://test2.1cb.kz/ScoreService/ScoreService");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
