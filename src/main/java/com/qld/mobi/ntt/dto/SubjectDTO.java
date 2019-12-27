package com.qld.mobi.ntt.dto;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public class SubjectDTO {
    private Long subjectId;
    private String subjectCode;
    private String subjectName;
    //so tin chi
    private String numberSession;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getNumberSession() {
        return numberSession;
    }

    public void setNumberSession(String numberSession) {
        this.numberSession = numberSession;
    }
}
