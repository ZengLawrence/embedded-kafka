package example.embeddedkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Publisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Publisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        this.kafkaTemplate.send("my-topic", message);
        log.info("Message sent: " + message);
    }
}
