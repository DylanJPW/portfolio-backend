package com.example.portfolioBackend.model;

import java.util.List;

public class ProjectDTO {
    private String name;
    private String description;
    private String repoLink;
    private List<String> tags;
    private ProjectImage image;

    public ProjectDTO() {
    }

    public ProjectDTO(String name, String description, String repoLink, List<String> tags, ProjectImage image) {
        this.name = name;
        this.description = description;
        this.repoLink = repoLink;
        this.tags = tags;
        this.image = image;
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

    public ProjectImage getImage() {
        return image;
    }

    public void setImage(ProjectImage image) {
        this.image = image;
    }
}
