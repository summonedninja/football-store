package soccer.soccerstore.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import soccer.soccerstore.dto.RegistrationDto;

@Component
public class KafkaProducer {
    private final KafkaTemplate<String, RegistrationDto> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, RegistrationDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, RegistrationDto registrationDto) {
        kafkaTemplate.send(topic, registrationDto);
    }
}
