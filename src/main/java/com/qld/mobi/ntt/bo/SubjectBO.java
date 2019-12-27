package com.qld.mobi.ntt.bo;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "subject")
public class SubjectBO {
    @Id
    @Column(name = "subject_id", length = 22)
    @GeneratedValue(strategy = IDENTITY)
    private Long subjectId;
    @Column(name = "subject_code", unique = true)
    private String subjectCode;
    @Column(name = "subject_name")
    private String subjectName;
    //so tin chi
    @Column(name = "number_session")
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
