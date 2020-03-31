package com.homework.dao.impl;

import com.homework.config.HibernateUtil;
import com.homework.dao.DAO;
import com.homework.entity.Subject;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SubjectDaoImpl implements DAO<Subject> {

    @Override
    public Subject findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Subject.class, id);
    }

    @Override
    public void save(Subject subject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(subject);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateT(Subject subject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(subject);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Subject subject) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(subject);
        tx1.commit();
        session.close();

    }

    @Override
    public List<Subject> findAll() {
        List<Subject> subjects = (List<Subject>) HibernateUtil.getSessionFactory().openSession()
                .createQuery("From Subject").list();
        return subjects;
    }
}
