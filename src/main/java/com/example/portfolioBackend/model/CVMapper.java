package com.example.portfolioBackend.model;

import java.util.List;
import java.util.stream.Collectors;

public class CVMapper {

    public static CV toCVEntity(CVDTO cvDTO) {
        CV cv = new CV();
        cv.setSummary(cvDTO.getSummary());
        cv.setUploadDate(cvDTO.getUploadDate());

        List<Skill> skills = cvDTO.getSkillList().stream()
                .map(skillDTO -> {
                    Skill skill = new Skill(
                            skillDTO.getName(),
                            skillDTO.getType(),
                            skillDTO.getYearsExperience(),
                            skillDTO.getDescription()
                    );
                    skill.setCv(cv);
                    return skill;
                }).collect(Collectors.toList());
        cv.setSkillList(skills);

        List<Experience> experiences = cvDTO.getExperienceList().stream()
                .map(expDTO -> {
                    Experience exp = new Experience(
                            expDTO.getCompanyName(),
                            expDTO.getStartDate(),
                            expDTO.getEndDate(),
                            expDTO.getPosition(),
                            expDTO.getDescription()
                    );
                    exp.setCv(cv);
                    return exp;
                }).collect(Collectors.toList());
        cv.setExperienceList(experiences);

        return cv;
    }
}
