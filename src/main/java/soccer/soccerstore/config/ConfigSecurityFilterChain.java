package soccer.soccerstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfigSecurityFilterChain {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf-> csrf.disable())
                .cors(cors-> cors.disable())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/main-page","/singUp","/create/user","/register","/registerPost","/view/card","/credit/card").permitAll()
                        .requestMatchers("/css/style.css","/css/about.css","/css/singUp.css","/css/formRegistration.css","/css/view_card.css","/css/creditCard.css").permitAll()
                        .requestMatchers("/about").authenticated())
                .formLogin(login-> login
                        .loginPage("/singIn")
                        .defaultSuccessUrl("/main-page",true)
                        .permitAll());
        return http.build();

    }
}
