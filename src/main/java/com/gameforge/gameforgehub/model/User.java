package com.gameforge.gameforgehub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Constructor vacío (obligatorio para JPA)
    public User() {}

    // --- GETTERS Y SETTERS (ESTO ES LO QUE TE FALTA) ---

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Opcional: Getter y Setter para el ID
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}