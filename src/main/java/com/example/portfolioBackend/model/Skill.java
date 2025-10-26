package com.example.portfolioBackend.model;

import com.example.portfolioBackend.model.enums.SkillType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id") // foreign key in Experience table
    @JsonIgnore
    private CV cv;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SkillType type;

    @Column
    private int yearsExperience;

    @Lob
    private String description;

    @Embedded
    private ImageObject image;

    public Skill() {

    }

    public Skill(String name, SkillType type, int yearsExperience, String description, ImageObject image) {
        this.name = name;
        this.type = type;
        this.yearsExperience = yearsExperience;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageObject getImage() {
        return image;
    }

    public void setImage(ImageObject image) {
        this.image = image;
    }
}
