package soccer.soccerstore.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import soccer.soccerstore.dto.RegistrationDto;
import soccer.soccerstore.servis.DefaultRegister;

@Component
public class KafkaConsumer {
    public final DefaultRegister defaultRegister;

    public KafkaConsumer(DefaultRegister defaultRegister) {
        this.defaultRegister = defaultRegister;
    }

    @KafkaListener(topics = "registration-topic",groupId ="registration-group",
        containerFactory = "kafkaListenerContainerFactoryMy")
    public void consumeMessage(RegistrationDto registrationDto) {
        System.out.println("Сообщение получено из kafka : " + registrationDto);
        defaultRegister.standardRegistrationUser(registrationDto);
        System.out.println("Пользователь успешно зарегистрирован");
    }
}
