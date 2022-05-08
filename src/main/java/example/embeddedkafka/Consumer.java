package example.embeddedkafka;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
public class Consumer {


    private @Getter final CountDownLatch latch = new CountDownLatch(1);

    private @Getter String lastMessage;

    @KafkaListener(topics = "my-topic", groupId = "consumer-group")
    public void processMessage(String content) {
        log.info("Message received: " + content);
        lastMessage = content;
        latch.countDown();
    }

}
