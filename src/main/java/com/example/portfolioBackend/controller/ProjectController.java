package com.example.portfolioBackend.controller;

import com.example.portfolioBackend.model.Project;
import com.example.portfolioBackend.model.ProjectDTO;
import com.example.portfolioBackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins="http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/addProject")
    public ResponseEntity<Project> createProject(
            @RequestBody ProjectDTO projectDto
    ) {
        try {
            Project newProject = projectService.createProject(
                    new Project(
                            projectDto.getName(),
                            projectDto.getDescription(),
                            projectDto.getImage(),
                            projectDto.getRepoLink(),
                            projectDto.getTags()
                    )
            );

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{projectId}")
                    .buildAndExpand(newProject.getProjectId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
