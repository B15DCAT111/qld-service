package com.qld.mobi.ntt.bo;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "subject_mark")
public class SubjectMarkBO {
    @Id
    @Column(name = "subject_mark_id", length = 22)
    @GeneratedValue(strategy = IDENTITY)
    private Long subjectMarkid;

    @Column(name = "student_code")
    private String studentCode;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "mark_cc")
    private String markCc;

    @Column(name = "mark_btl")
    private String markBtl;

    @Column(name = "mark_ck")
    private String markCk;

    public Long getSubjectMarkid() {
        return subjectMarkid;
    }

    public void setSubjectMarkid(Long subjectMarkid) {
        this.subjectMarkid = subjectMarkid;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getMarkCc() {
        return markCc;
    }

    public void setMarkCc(String markCc) {
        this.markCc = markCc;
    }

    public String getMarkBtl() {
        return markBtl;
    }

    public void setMarkBtl(String markBtl) {
        this.markBtl = markBtl;
    }

    public String getMarkCk() {
        return markCk;
    }

    public void setMarkCk(String markCk) {
        this.markCk = markCk;
    }
}
