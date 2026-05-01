package com.gameforge.gameforgehub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status; // Ej: "PENDING", "IN_PROGRESS", "COMPLETED"

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
 // Dentro de Task.java

    @ManyToOne
    @JoinColumn(name = "project_id") // Esta es la columna que se creará en la DB
    private Project project; // <--- ESTA es la propiedad que Hibernate está buscando

    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public Task() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}