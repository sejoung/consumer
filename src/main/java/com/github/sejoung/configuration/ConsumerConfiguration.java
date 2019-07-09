package com.github.sejoung.configuration;

import com.github.sejoung.service.Telegram;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;

/**
 * @author kim se joung
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class ConsumerConfiguration {

    private final Telegram telegram;

    @KafkaListener(topicPattern = "test", errorHandler = "errorHandler")
    public void listen(List<String> list) {


        list.forEach((message)->{
            telegram.sendMessage(message);
        });

        /*
        retryTemplate.execute((retryCallback) -> {
            var retryCount = retryCallback.getRetryCount();
            if (retryCount > 0) {
                log.error("retryCount={}", retryCount);
            }
            return null;
        });
*/
    }

    @Bean
    public KafkaListenerErrorHandler errorHandler() {
        return (var message, var exception) -> {
            log.error("error payload = {}, excepion = {} ", message.getPayload().toString(),
                exception);
            return "error";
        };
    }

}
