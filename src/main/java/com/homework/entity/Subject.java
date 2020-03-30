package com.homework.entity;

import javax.persistence.Embedded;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.util.Set;

public class Subject {
    private int subjectID;
    private String name;
    private Set<School> schools;

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

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }
}
