package com.gameforge.gameforgehub.controller;

import com.gameforge.gameforgehub.model.Project;
import com.gameforge.gameforgehub.model.User;
import com.gameforge.gameforgehub.repository.ProjectRepository;
import com.gameforge.gameforgehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/create")
    public String createProject(@RequestParam String name, @RequestParam String desc) {
        Project project = new Project();
        project.setName(name);
        project.setDescription(desc);
      
        projectRepository.save(project);
        return "Proyecto '" + name + "' creado con éxito.";
    }

    @GetMapping("/all")
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    // T5: Solo dejamos la versión que requiere adminId para cumplir con el Milestone 3
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @RequestParam Long adminId) {
        User admin = userRepository.findById(adminId).orElse(null);

        if (admin == null || !"ADMIN".equals(admin.getRole())) {
            return "Error: Solo los administradores pueden borrar proyectos.";
        }

        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return "Proyecto " + id + " eliminado por el administrador: " + admin.getUsername();
        }
        return "Error: El proyecto no existe.";
    }
} 