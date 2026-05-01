package com.gameforge.gameforgehub.service;

import com.gameforge.gameforgehub.model.User;
import com.gameforge.gameforgehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password) {
        // Buscamos al usuario, si existe comparamos pass, si no existe devolvemos false
        return userRepository.findByUsername(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    public void logout() {
        // Por ahora este método no devuelve nada (void)
        System.out.println("Lógica de logout ejecutada");
    }
}