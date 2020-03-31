package com.homework.entity;
import javax.persistence.Embedded;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.util.Set;

public class School {
    private int schoolID;
    private String type;
    private Set<Subject> subjects;
    private Student student;


    @Embedded
    private Modification modification;

    @PrePersist
    private void prePersist() {
        if (modification == null) {
            modification  = new Modification();
        }
        modification.setCreateDate(new Date());
    }

    @PreUpdate
    private void preUpdate() {
        modification.setModifyDate(new Date());
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}
