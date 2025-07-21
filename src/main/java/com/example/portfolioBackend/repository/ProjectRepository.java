package com.example.portfolioBackend.repository;

import com.example.portfolioBackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
