package example.embeddedkafka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(topics = "my-topic", bootstrapServersProperty = "spring.kafka.bootstrap-servers")
class EmbeddedKafkaApplicationTests {

	@Test
	void contextLoads() {
	}

}
