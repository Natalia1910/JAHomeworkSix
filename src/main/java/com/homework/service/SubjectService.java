package com.homework.service;

import com.homework.dao.impl.SubjectDaoImpl;
import com.homework.entity.Subject;

import java.util.List;

public class SubjectService {

    SubjectDaoImpl subjectDao = new SubjectDaoImpl();

    public Subject findSubject(int id) {
        return subjectDao.findById(id);
    }

    public void saveSubject(Subject subject) {
        subjectDao.save(subject);
    }

    public void deleteSubject(Subject subject) {
        subjectDao.delete(subject);
    }

    public void updateSubject(Subject subject) {
        subjectDao.updateT(subject);
    }

    public List<Subject> findAllSubjects() {
        return subjectDao.findAll();
    }
}
