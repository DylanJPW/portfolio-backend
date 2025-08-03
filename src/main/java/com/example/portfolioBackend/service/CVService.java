package com.example.portfolioBackend.service;

import com.example.portfolioBackend.model.CV;
import com.example.portfolioBackend.model.Experience;
import com.example.portfolioBackend.model.Skill;
import com.example.portfolioBackend.model.enums.SkillType;
import com.example.portfolioBackend.repository.CVRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        cv.setSummary(extractBetween(parsedText, "PROFILE", "SKILLS"));

        String skillsSection = extractBetween(parsedText, "SKILLS", "WORK EXPERIENCE");
        List<Skill> skills = parseSkills(skillsSection);
        cv.setSkillList(skills);

        String experienceSection = extractBetween(parsedText, "WORK EXPERIENCE", "EDUCATION");
        List<Experience> experiences = parseExperience(experienceSection);
        cv.setExperienceList(experiences);

        return cv;
    }

    public String extractFileText (MultipartFile cvFile) throws IOException {
        PDDocument document = PDDocument.load(cvFile.getInputStream());
        PDFTextStripper stripper = new PDFTextStripper();
        return stripper.getText(document);
    }

    private String extractBetween(String text, String start, String end) {
        int startIndex = text.indexOf(start);
        int endIndex = text.indexOf(end);
        if (startIndex == -1 || endIndex == -1) return "";
        return text.substring(startIndex + start.length(), endIndex);
    }

    private List<Skill> parseSkills(String skillsText) {
        List<Skill> skills = new ArrayList<>();
        String[] skillStrings = skillsText.split("•");
        for (int i = 0; i < skillStrings.length; i++) {
            String skillName = skillStrings[i].trim();
            if (!skillName.isEmpty()) {
                Skill skill = new Skill();
                skill.setName(skillName);
                skill.setType(i < skillStrings.length / 2 ? SkillType.HARD : SkillType.SOFT);
                skills.add(skill);
            }
        }
        return skills;
    }

    private List<Experience> parseExperience(String experienceText) {
        List<Experience> experiences = new ArrayList<>();

        String[] jobs = experienceText.split("(?=\\b[A-Z ]+, [A-Z ]+)");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);

        for (String job : jobs) {
            job = job.trim();

            Experience experience = new Experience();

            String[] lines = job.split("\n");
            experience.setPosition(lines[0].split(",")[0].trim());
            experience.setCompanyName(lines[0].split(",")[1].trim());

            for (String line : lines) {
                if (line.startsWith("Dates:")) {
                    String dateRange = line.replace("Dates:", "").trim();
                    String[] dates = dateRange.split("–");

                    String startDateStr = cleanDate(dates[0]);
                    experience.setStartDate(parseDate(startDateStr, formatter));

                    if (dates.length > 1) {
                        String endDateStr = dates[1].trim();
                        if (endDateStr.equalsIgnoreCase("Current")) {
                            experience.setEndDate(null); // null means ongoing
                        } else {
                            experience.setEndDate(parseDate(cleanDate(endDateStr), formatter));
                        }
                    }
                } else {
                    StringBuilder description = new StringBuilder();
                    description.append(line.trim()).append(" ");
                    experience.setDescription(description.toString().trim());
                    experiences.add(experience);
                }
            }
            experiences.add(experience);
        }
        return experiences;
    }

    private String cleanDate(String date) {
        return date.replaceAll("(st|nd|rd|th)", "").trim();
    }

    private LocalDate parseDate(String dateStr, DateTimeFormatter formatter) {
        return LocalDate.parse(dateStr, formatter);
    }

}
