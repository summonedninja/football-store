package soccer.soccerstore.servis;

import org.springframework.stereotype.Service;
import soccer.soccerstore.model.User;
@Service
public interface UserService {
    void createUser(User user);
}
