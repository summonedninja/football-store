package soccer.soccerstore.servis;

import org.springframework.stereotype.Service;
import soccer.soccerstore.dto.RegistrationDto;

@Service
public interface DefaultRegister {
    void standardRegistrationUser(RegistrationDto registrationDto);
}
