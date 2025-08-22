package com.example.portfolioBackend.model;

import com.example.portfolioBackend.model.enums.SkillType;

public class SkillDTO {
    private String name;
    private SkillType type;
    private int yearsExperience;
    private String description;

    public SkillDTO() {
    }

    public SkillDTO(String name, SkillType type, int yearsExperience, String description) {
        this.name = name;
        this.type = type;
        this.yearsExperience = yearsExperience;
        this.description = description;
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
}
