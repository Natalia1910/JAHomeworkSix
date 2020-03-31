package com.homework;

import com.homework.entity.Student;
import com.homework.service.SchoolService;
import com.homework.service.StudentService;
import com.homework.service.SubjectService;

public class Main {
    public static void main(String[] args) {

        SchoolService schoolService = new SchoolService();
        StudentService studentService = new StudentService();
        SubjectService subjectService = new SubjectService();

        Student student = new Student();
        student.setName("Masha");
        student.setLastName("Ivanova");
        student.setAge(15);

        studentService.saveStudent(student);
    }
}
