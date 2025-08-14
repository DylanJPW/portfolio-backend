package com.example.portfolioBackend.repository;

import com.example.portfolioBackend.model.CV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CVRepository extends JpaRepository<CV, Integer> {
    Optional<CV> findFirstByOrderByUploadDateDesc();
}
