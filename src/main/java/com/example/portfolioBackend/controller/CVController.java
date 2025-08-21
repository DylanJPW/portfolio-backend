package com.example.portfolioBackend.controller;

import com.example.portfolioBackend.model.CV;
import com.example.portfolioBackend.model.CVDTO;
import com.example.portfolioBackend.service.CVService;
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

    @PostMapping(value = "/parseCVFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CV> parseCVFile (@RequestParam("file") MultipartFile file) {
        try {
            CV parsedCVObject = cvService.processCVFile(file);

            return new ResponseEntity<>(parsedCVObject, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/saveCV")
    public ResponseEntity<CV> saveCV (@RequestBody CVDTO cvDto) {
        try {
            CV savedCV = cvService.saveCV(cvDto);

            return new ResponseEntity<>(savedCV, HttpStatus.OK);
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

    @GetMapping("/getLatestCV")
    public ResponseEntity<CV> getLatestCV () {
        try {
            CV cv = cvService.getLatestCV().get();

            return new ResponseEntity<>(cv, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
