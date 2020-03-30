package com.homework.service;

import com.homework.config.SessionUtil;
import com.homework.entity.School;
import com.homework.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SchoolService extends SessionUtil implements DAO<School> {

    @Override
    public void add(School school) {
        openTransactionSession();
        Session session = getSession();
        session.save(school);
        closeTransactionSession();
    }

    @Override
    public List<School> findAll() {
        openTransactionSession();
        String sql = "SELECT * FROM school";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(School.class);
        List<School> schoolList = query.list();
        closeTransactionSession();
        return schoolList;
    }

    @Override
    public void delete(int id) {
        openTransactionSession();
        Session session = getSession();
        session.remove(id);
        closeTransactionSession();
    }

    @Override
    public School getByID(int id) {
        openTransactionSession();
        String sql = "SELECT * FROM school WHERE school_id = ?";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(School.class);
        query.setParameter("school_id", id);
        School school = (School) query.getSingleResult();

        closeTransactionSession();
        return school;
    }

    @Override
    public void update(School school) {
        openTransactionSession();
        Session session = getSession();
        session.update(school);
        closeTransactionSession();
    }
}
