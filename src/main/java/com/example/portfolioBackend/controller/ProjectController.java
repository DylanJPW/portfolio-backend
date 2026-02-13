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
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/projects")
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
                    .path("/{id}")
                    .buildAndExpand(newProject.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        if (projectService.deleteProject(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/updateProject/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody ProjectDTO newProject) {
        try {
            Project projectToUpdate = projectService.getProjectById(id).get();
            projectToUpdate.setName(newProject.getName());
            projectToUpdate.setDescription(newProject.getDescription());
            projectToUpdate.setRepoLink(newProject.getRepoLink());
            projectToUpdate.setImage(newProject.getImage());
            projectToUpdate.setTags(newProject.getTags());

            if (projectService.updateProject(projectToUpdate)) {
                return ResponseEntity.ok(projectToUpdate);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
