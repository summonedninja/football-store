package soccer.soccerstore.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soccer.soccerstore.dto.RegistrationDto;
import soccer.soccerstore.model.Role;
import soccer.soccerstore.model.User;

@Service
public class RegistrationService implements DefaultRegister {
    @Autowired
    private UserService userService;

    @Override
    public void standardRegistrationUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        user.setRole(Role.USER);
        userService.createUser(user);
    }
}


