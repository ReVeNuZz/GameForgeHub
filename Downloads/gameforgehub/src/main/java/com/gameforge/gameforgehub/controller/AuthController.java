package com.gameforge.gameforgehub.controller;

import com.gameforge.gameforgehub.service.AuthService;
import com.gameforge.gameforgehub.model.User;
import com.gameforge.gameforgehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private UserRepository userRepository; // esto es para poder registrar rápido
    
    // GetMapping para probar en el navegador
    @GetMapping("/login") 
    public String login(@RequestParam String username, @RequestParam String password) {
        if (authService.login(username, password)) {
            return "¡Login exitoso! Bienvenido " + username;
        }
        return "Error: Usuario o contraseña incorrectos.";
    }

    
    @GetMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        User newUser = new User();
       newUser.setUsername(username);
        newUser.setPassword(password);
        userRepository.save(newUser);
        return "Usuario '" + username + "' creado con éxito. Ya puedes intentar el login.";
    }
    
    
    
    @GetMapping("/logout")
    public String logout() {
        authService.logout();
        return "Has cerrado sesión correctamente.";
    }
}