package com.homework.service;

import com.homework.dao.impl.StudentDaoImpl;
import com.homework.entity.Student;

import java.util.List;

public class StudentService {

    StudentDaoImpl studentDao = new StudentDaoImpl();

    public Student findStudent(int id) {
        return studentDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentDao.updateT(student);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }
}
