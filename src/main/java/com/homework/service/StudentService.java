package com.homework.service;

import com.homework.config.SessionUtil;
import com.homework.entity.Student;
import com.homework.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentService extends SessionUtil implements DAO<Student> {

    @Override
    public void add(Student student) {
        openTransactionSession();
        Session session = getSession();
        session.save(student);
        closeTransactionSession();

    }

    @Override
    public List<Student> findAll() {
        openTransactionSession();
        String sql = "SELECT * FROM student";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Student.class);
        List<Student> studentList = query.list();
        closeTransactionSession();
        return studentList;
    }

    @Override
    public void delete(int id) {
        openTransactionSession();
        Session session = getSession();
        session.remove(id);
        closeTransactionSession();
    }

    @Override
    public Student getByID(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM student WHERE student_id = ?";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Student.class);
        query.setParameter("student_id", id);
        Student student = (Student) query.getSingleResult();

        closeTransactionSession();
        return student;
    }

    @Override
    public void update(Student student) {
        openTransactionSession();
        Session session = getSession();
        session.update(student);
        closeTransactionSession();
    }
}
