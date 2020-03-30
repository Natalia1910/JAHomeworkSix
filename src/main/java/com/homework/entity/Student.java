package com.homework.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;

    @Column(name = "name", nullable = false, length = 33)
    private String name;

    @Column(name = "last_name", nullable = false, length = 33)
    private String lastName;

    @Column(name = "age", nullable = false, length = 3)
    private int age;

    private List<Subject> subjects = new ArrayList<>();

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

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
