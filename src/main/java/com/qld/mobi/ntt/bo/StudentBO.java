package com.qld.mobi.ntt.bo;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "student")
public class StudentBO {
    @Id
    @Column(name = "student_info_id", length = 22)
    @GeneratedValue(strategy = IDENTITY)
    private Long studentId;
    @Column(name = "student_code", unique = true)
    private String studentCode;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "class_code")
    private String classCode;
    @Column(name = "student_adress")
    private String studentAdress;
    @Column(name = "student_birth_day")
    private String studentBirhDay;
    @Column(name = "student_email")
    private String studentEmail;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getStudentAdress() {
        return studentAdress;
    }

    public void setStudentAdress(String studentAdress) {
        this.studentAdress = studentAdress;
    }

    public String getStudentBirhDay() {
        return studentBirhDay;
    }

    public void setStudentBirhDay(String studentBirhDay) {
        this.studentBirhDay = studentBirhDay;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
