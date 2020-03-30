package com.homework.dao;

import java.util.List;

public interface DAO<T> {

    void add (T t);

    List<T> findAll();

    void delete(int id);

    T getByID(int id);

    void update(T t);
}
