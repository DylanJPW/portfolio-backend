package com.example.portfolioBackend.service;

import com.example.portfolioBackend.model.CV;
import com.example.portfolioBackend.repository.CVRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CVService {

    @Autowired
    CVRepository cvRepository;

    public void saveCV(MultipartFile cvFile) throws IOException {

        CV cv = processCVFile(cvFile);

        cvRepository.save(cv);
    }

    public CV processCVFile (MultipartFile cvFile) throws IOException {
        String parsedText = extractFileText(cvFile);

        CV cv = new CV();



        return cv;
    }

    public String extractFileText (MultipartFile cvFile) throws IOException {
        PDDocument document = PDDocument.load(cvFile.getInputStream());
        PDFTextStripper stripper = new PDFTextStripper();
        return stripper.getText(document);
    }

}
