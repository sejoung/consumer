package com.github.sejoung.configuration;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author kim se joung
 */
@Slf4j
@Configuration
public class CommonConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().setReadTimeout(Duration.ofMillis(500))
            .setConnectTimeout(Duration.ofMillis(500)).build();
    }

}
