package com.flexit.spacetoursinc.propellants.client;

import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
class PropellantClientConfig {
    @Value("${propellant.client.connectTimeout:5000}")
    private Integer connectTimeoutMillis;

    @Value("${propellant.client.readTimeout:2000}")
    private Integer readTimeoutMillis;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeoutMillis, TimeUnit.MILLISECONDS, readTimeoutMillis, TimeUnit.MILLISECONDS, true);
    }
}
