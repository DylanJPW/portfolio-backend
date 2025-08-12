package com.example.portfolioBackend.controller;

import com.example.portfolioBackend.model.CV;
import com.example.portfolioBackend.service.CVService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin(origins="http://localhost:3000")
public class CVController {

    @Autowired
    private CVService cvService;

    @PostMapping(value = "/uploadCV", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadCV (@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        try {
            cvService.saveCV(file);

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getCV/{id}")
    public ResponseEntity<CV> getCV (@PathVariable int id) {
        try {
            CV cv = cvService.getCVById(id).get();

            return new ResponseEntity<>(cv, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
