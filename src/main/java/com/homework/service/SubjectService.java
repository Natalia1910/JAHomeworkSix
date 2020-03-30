package com.homework.service;

import com.homework.config.SessionUtil;
import com.homework.entity.Subject;
import com.homework.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SubjectService extends SessionUtil implements DAO<Subject> {

    @Override
    public void add(Subject subject) {
        openTransactionSession();
        Session session = getSession();
        session.save(subject);
        closeTransactionSession();

    }

    @Override
    public List<Subject> findAll() {
        openTransactionSession();
        String sql = "SELECT * FROM subject";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Subject.class);
        List<Subject> subjectList = query.list();
        closeTransactionSession();
        return subjectList;
    }

    @Override
    public void delete(int id) {
        openTransactionSession();
        Session session = getSession();
        session.remove(id);
        closeTransactionSession();

    }

    @Override
    public Subject getByID(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM subject WHERE subject_id = ?";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Subject.class);
        query.setParameter("subject_id", id);
        Subject subject = (Subject) query.getSingleResult();

        closeTransactionSession();
        return subject;
    }

    @Override
    public void update(Subject subject) {
        openTransactionSession();
        Session session = getSession();
        session.update(subject);
        closeTransactionSession();

    }
}
