package com.gameforge.gameforgehub.service;

import com.gameforge.gameforgehub.model.Task;
import com.gameforge.gameforgehub.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Crear o Actualizar
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Listar tareas de un usuario específico
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    // Eliminar una tarea
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Buscar una sola tarea por ID (útil para actualizar)
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    
 // Agrega estas líneas al final de tu TaskService
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}