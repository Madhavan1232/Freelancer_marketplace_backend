package com.first.appdevops_fm.service;

import com.first.appdevops_fm.entity.ProjectTable;
import com.first.appdevops_fm.repository.ProjectTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTableService {

    @Autowired
    private ProjectTableRepository projectTableRepository;

    public String createProject(ProjectTable project) {
        if (project.getId() != null) {
            return "Project ID must be null for new projects.";
        } else {
            projectTableRepository.save(project);
            return "Project created successfully.";
        }
    }

    public List<ProjectTable> getAllProjects() {
        return projectTableRepository.findAll();
    }

    public Optional<ProjectTable> getProjectById(Long id) {
        return projectTableRepository.findById(id);
    }

    public String updateProject(Long id, ProjectTable.DataTransferObject dto) {
        Optional<ProjectTable> optionalProject = projectTableRepository.findById(id);
        if (optionalProject.isPresent()) {
            ProjectTable existingProject = optionalProject.get();
            existingProject.updateFromDto(dto);
            projectTableRepository.save(existingProject);
            return "Project updated successfully.";
        }
        return "Project not found.";
    }

    public String deleteProject(Long id) {
        if (projectTableRepository.existsById(id)) {
            projectTableRepository.deleteById(id);
            return "Project deleted successfully.";
        }
        return "Project not found.";
    }
}
