package controller;

import service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService = new AuthService();

    @GetMapping("/auth/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (authService.login(username, password)) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    @GetMapping("/auth/logout")
    public String logout() {
        return authService.logout();
    }
}