package example.embeddedkafka;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@EmbeddedKafka
class SendAndReceiveTest {

    @Autowired
    private Publisher publisher;

    @Autowired
    private Consumer consumer;

    @Test
    @DisplayName("Test send one message and receive that")
    public void testSendAndReceiveOneMessage() throws Exception {
        publisher.send("Hello world!");
        assertThat(consumer.getLatch().await(10, TimeUnit.SECONDS), is(true));
        assertThat(consumer.getLastMessage(), is("Hello world!"));
    }
}
