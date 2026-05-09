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
    private UserRepository userRepository;
    
    @GetMapping("/login") 
    public String login(@RequestParam String username, @RequestParam String password) {
        if (authService.login(username, password)) {
            return "¡Login exitoso! Bienvenido " + username;
        }
        return "Error: Usuario o contraseña incorrectos.";
    }

    //Role-based permissions 
    @GetMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam(defaultValue = "USER") String role) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        
        // Si role llega nulo por alguna razón, le asignamos USER por defecto
        String assignedRole = (role != null) ? role.toUpperCase() : "USER";
        newUser.setRole(assignedRole); 
        
        userRepository.save(newUser);
        return "Usuario '" + username + "' creado con éxito como " + newUser.getRole();
    }
    
    @GetMapping("/logout")
    public String logout() {
        authService.logout();
        return "Has cerrado sesión correctamente.";
    }
}