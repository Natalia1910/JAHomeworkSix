package com.homework.service;

import com.homework.dao.impl.SchoolDaoImpl;
import com.homework.entity.School;

import java.util.List;

public class SchoolService {

    private SchoolDaoImpl schoolDao = new SchoolDaoImpl();

    public School findSchool(int id) {
        return schoolDao.findById(id);
    }

    public void saveSchool(School school) {
        schoolDao.save(school);
    }

    public void deleteSchool(School school) {
        schoolDao.delete(school);
    }

    public void updateSchool(School school) {
        schoolDao.updateT(school);
    }

    public List<School> findAllSchools() {
        return schoolDao.findAll();
    }

}

