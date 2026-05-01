package com.gameforge.gameforgehub.controller;

import com.gameforge.gameforgehub.model.Project;
import com.gameforge.gameforgehub.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/create")
    public String createProject(@RequestParam String name, @RequestParam String desc) {
        Project project = new Project();
        project.setName(name);
        project.setDescription(desc);
        // Por ahora lo guardamos sin asignar user para probar rápido
        projectRepository.save(project);
        return "Proyecto '" + name + "' creado con éxito.";
    }

    @GetMapping("/all")
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        projectRepository.deleteById(id);
        return "Proyecto eliminado.";
    }
}