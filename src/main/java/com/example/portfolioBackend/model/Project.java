package com.example.portfolioBackend.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Embedded
    private ProjectImage image;

    @Column
    private String repoLink;

    @ElementCollection
    private List<String> tags;

    public Project() {

    }

    public Project(String name, String description, ProjectImage image, String repoLink, List<String> tags) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.repoLink = repoLink;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectImage getImage() {
        return image;
    }

    public void setImage(ProjectImage image) {
        this.image = image;
    }

    public String getRepoLink() {
        return repoLink;
    }

    public void setRepoLink(String repoLink) {
        this.repoLink = repoLink;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
