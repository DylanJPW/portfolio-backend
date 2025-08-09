package com.example.portfolioBackend.repository;

import com.example.portfolioBackend.model.CV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<CV, Integer> {
}
