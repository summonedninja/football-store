package soccer.soccerstore.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import soccer.soccerstore.model.User;
import soccer.soccerstore.servis.UserService;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
