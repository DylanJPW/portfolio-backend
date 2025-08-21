package com.example.portfolioBackend.model;

import java.util.Date;
import java.util.List;

public class CVDTO {
    private String summary;
    private List<ExperienceDTO> experienceList;
    private List<SkillDTO> skillList;
    private Date uploadDate;

    public CVDTO() {
    }

    public CVDTO(String summary, List<ExperienceDTO> experienceList, List<SkillDTO> skillList, Date uploadDate) {
        this.summary = summary;
        this.experienceList = experienceList;
        this.skillList = skillList;
        this.uploadDate = uploadDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<ExperienceDTO> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<ExperienceDTO> experienceList) {
        this.experienceList = experienceList;
    }

    public List<SkillDTO> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<SkillDTO> skillList) {
        this.skillList = skillList;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
