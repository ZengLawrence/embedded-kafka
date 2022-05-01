package example.embeddedkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);

    public Publisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        this.kafkaTemplate.send("my-topic", message);
        LOGGER.info("Message sent: " + message);
    }
}
