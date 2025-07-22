package com.example.portfolioBackend.service;

import com.example.portfolioBackend.model.Project;
import com.example.portfolioBackend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project project) {
        if (projectRepository.existsById(project.getProjectId())) return null;
        return projectRepository.save(project);
    }
}
