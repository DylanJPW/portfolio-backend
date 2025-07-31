package com.example.portfolioBackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin(origins="http://localhost:3000")
public class CVController {

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadCv (@RequestParam MultipartFile cv) {

    }
}
