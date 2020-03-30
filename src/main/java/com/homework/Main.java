package com.homework;

import com.homework.config.HibernateUtil;
import com.homework.entity.School;
import com.homework.entity.Student;
import com.homework.entity.Subject;
import com.homework.service.SchoolService;
import com.homework.service.StudentService;
import com.homework.service.SubjectService;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        SchoolService schoolService = new SchoolService();
        StudentService studentService = new StudentService();
        SubjectService subjectService = new SubjectService();

        School school = new School();
        school.setType("Primary");

        Student student = new Student();
        student.setName("Ivan");
        student.setLastName("Ivanov");
        student.setAge(15);

        Subject subject = new Subject();
        subject.setName("psychology");

        Set<School> schools = new HashSet<>();
        schools.add(school);
        subject.setSchools(schools);

        Set<Subject> subjects = new HashSet<>();
        subjects.add(subject);
        school.setSubjects(subjects);

        schoolService.add(school);
        studentService.add(student);
        subjectService.add(subject);

        HibernateUtil.shutdown();
    }
}
