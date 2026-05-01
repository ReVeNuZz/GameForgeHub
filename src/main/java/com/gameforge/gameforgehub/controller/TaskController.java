package com.gameforge.gameforgehub.controller;

import com.gameforge.gameforgehub.model.Task;
import com.gameforge.gameforgehub.model.User;
import com.gameforge.gameforgehub.repository.TaskRepository;
import com.gameforge.gameforgehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository; // Esto arregla el error de la línea 21

    @GetMapping("/add")
    public String addTask(@RequestParam String title, @RequestParam String desc, @RequestParam Long userId) {
        // Buscamos al usuario en la base de datos
        User user = userRepository.findById(userId).orElse(null);
        
        if (user == null) {
            return "Error: El usuario con ID " + userId + " no existe. Regístralo primero en /auth/register";
        }

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(desc);
        task.setUser(user);
        
        // Evitamos errores de relación con Proyecto por ahora
        task.setProject(null); 

        taskRepository.save(task); // Esto arregla el error de la línea 36
        return "Tarea '" + title + "' creada con éxito para el usuario: " + user.getUsername();
    }

    @GetMapping("/list")
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }
}