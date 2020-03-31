package com.homework.dao.impl;

import com.homework.config.HibernateUtil;
import com.homework.dao.DAO;
import com.homework.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoImpl implements DAO<Student> {

    @Override
    public Student findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    @Override
    public void save(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();

    }

    @Override
    public void updateT(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = (List<Student>) HibernateUtil.getSessionFactory().openSession()
                .createQuery("From Student").list();
        return students;
    }
}
