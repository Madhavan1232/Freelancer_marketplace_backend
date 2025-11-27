package com.first.appdevops_fm.service;

import com.first.appdevops_fm.entity.Project;
import com.first.appdevops_fm.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public String createProject(Project project) {
        if(project.getId() != null){
            return "Project ID must be null for new projects.";
        } else {
            projectRepository.save(project);
            return "Project created successfully.";
        }
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public String updateProject(Long id, Project.DataTransferObject dto) {
        if(projectRepository.findById(id).isPresent()) {
            Project existingProject = projectRepository.findById(id).get();
            existingProject.updateFromDto(dto);
            projectRepository.save(existingProject);
            return "Project updated successfully.";
        }
        return "Project not found.";
    }

    public String deleteProject(Long id) {
        if(projectRepository.findById(id).isPresent()) {
            projectRepository.deleteById(id);
            return "Project deleted successfully.";
        }
        return "Project not found.";
    }
}