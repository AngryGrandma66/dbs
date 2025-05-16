package com.example.dbs_semestralka.dao;

import jakarta.persistence.EntityManager;

public interface GenericDAO<T, ID> {
    void persist(T entity);
    T findById(ID id);
    T update(T entity);
    void remove(T entity);
}