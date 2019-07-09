package com.github.sejoung.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class Telegram {

    private final RestTemplate restTemplate;

    @Value("${telegram.url}")
    private String telegramUrl;

    public void sendMessage(String message) {
        var headers = new HttpHeaders();
        var entity = new HttpEntity<String>(headers);
        restTemplate.exchange(telegramUrl + message, HttpMethod.GET, entity, String.class);
    }
}
