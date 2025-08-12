package com.example.portfolioBackend.service;

import com.example.portfolioBackend.model.Project;
import com.example.portfolioBackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(int id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        if (projectRepository.existsById(project.getId())) return null;
        return projectRepository.save(project);
    }

    public boolean deleteProject(int id) {
        if (!projectRepository.existsById(id)) return false;
        projectRepository.deleteById(id);
        return true;
    }

    public boolean updateProject(Project project) {
        if (!projectRepository.existsById(project.getId())) return false;
        projectRepository.save(project);
        return true;
    }
}
