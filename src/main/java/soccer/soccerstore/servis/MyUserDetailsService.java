package soccer.soccerstore.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import soccer.soccerstore.config.MyUserDetails;
import soccer.soccerstore.model.User;
import soccer.soccerstore.repository.UserRepository;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        return user.map(u-> new MyUserDetails(u))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
