package com.example.portfolioBackend.model;

import java.time.LocalDate;

public class ExperienceDTO {
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String position;
    private String description;

    public ExperienceDTO() {
    }

    public ExperienceDTO(String companyName, LocalDate startDate, LocalDate endDate, String position, String description) {
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
