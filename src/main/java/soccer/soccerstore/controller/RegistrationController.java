package soccer.soccerstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import soccer.soccerstore.dto.RegistrationDto;
import soccer.soccerstore.kafka.KafkaProducer;


@Controller
public class RegistrationController {
    private final KafkaProducer kafkaProducer;

    public RegistrationController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/register")
    public String registerPageForm() {
        return "singUp";
    }

    @PostMapping("/registerPost")
    public String registerUser(@ModelAttribute RegistrationDto registrationDto) {
         kafkaProducer.sendMessage("registration-topic", registrationDto);
        return "redirect:/main-page";
    }

}
