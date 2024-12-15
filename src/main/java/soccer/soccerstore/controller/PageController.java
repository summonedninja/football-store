package soccer.soccerstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/main-page")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/singIn")
    public String singIn() {
        return "singIn";
    }

    @GetMapping("/view/card")
    public String viewCard() {
        return "view_card";
    }
    @GetMapping("/credit/card")
    public String formCreditCart() {
        return "forma_credit_card";
    }
}
