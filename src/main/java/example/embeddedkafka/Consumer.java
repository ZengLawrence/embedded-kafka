package example.embeddedkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private final CountDownLatch latch = new CountDownLatch(1);

    private String lastMessage;

    @KafkaListener(topics = "my-topic", groupId = "consumer-group")
    public void processMessage(String content) {
        LOGGER.info("Message received: " + content);
        lastMessage = content;
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
