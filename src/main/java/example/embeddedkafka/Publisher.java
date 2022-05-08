package example.embeddedkafka;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Publisher {

    final private @NonNull KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        this.kafkaTemplate.send("my-topic", message);
        log.info("Message sent: " + message);
    }
}
