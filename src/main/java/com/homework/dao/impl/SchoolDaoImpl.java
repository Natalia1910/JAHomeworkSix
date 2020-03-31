package com.homework.dao.impl;

import com.homework.config.HibernateUtil;
import com.homework.dao.DAO;
import com.homework.entity.School;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SchoolDaoImpl implements DAO<School> {

    @Override
    public School findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(School.class, id);
    }

    @Override
    public void save(School school) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(school);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateT(School school) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(school);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(School school) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(school);
        tx1.commit();
        session.close();
    }

    @Override
    public List<School> findAll() {
        List<School> schools = (List<School>) HibernateUtil.getSessionFactory().openSession()
                .createQuery("From School").list();
        return schools;
    }
}
