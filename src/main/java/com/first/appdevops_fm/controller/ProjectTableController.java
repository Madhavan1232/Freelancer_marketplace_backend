package com.first.appdevops_fm.controller;

import com.first.appdevops_fm.entity.ProjectTable;
import com.first.appdevops_fm.service.ProjectTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects-tables")
@CrossOrigin(origins = "*")
public class ProjectTableController {

    @Autowired
    private ProjectTableService projectTableService;

    @PostMapping
    public String createProject(@RequestBody ProjectTable project) {
        return projectTableService.createProject(project);
    }

    @GetMapping
    public List<ProjectTable> getAllProjects() {
        return projectTableService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<ProjectTable> getProjectById(@PathVariable Long id) {
        return projectTableService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public String updateProject(@PathVariable Long id, @RequestBody ProjectTable.DataTransferObject dto) {
        return projectTableService.updateProject(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        return projectTableService.deleteProject(id);
    }
}
