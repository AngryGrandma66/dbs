package com.example.dbs_semestralka.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {
    protected final Class<T> clazz;
    protected final EntityManager em;

    public GenericDAOImpl(Class<T> clazz) {
        this.clazz = clazz;
        this.em = JPAUtil.createEntityManager();
    }
    public GenericDAOImpl(Class<T> clazz, EntityManager em) {
        this.clazz = clazz;
        this.em = em;
    }


    @Override
    public void persist(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
    }

    @Override
    public T findById(ID id) {
        return em.find(clazz, id);
    }

    @Override
    public T update(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        T merged = em.merge(entity);
        tx.commit();
        return merged;
    }

    @Override
    public void remove(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        tx.commit();
    }
}
