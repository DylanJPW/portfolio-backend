package com.example.portfolioBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cv_id") // foreign key in Experience table
    @JsonIgnore
    private CV cv;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column(nullable = false)
    private String position;

    @Lob
    private String description;

    @Embedded
    private ImageObject image;

    public Experience() {

    }

    public Experience(String companyName, LocalDate startDate, LocalDate endDate, String position, String description, ImageObject image) {
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
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

    public ImageObject getImage() {
        return image;
    }

    public void setImage(ImageObject image) {
        this.image = image;
    }
}
