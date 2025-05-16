package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.model.Recept;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.time.OffsetDateTime;

public class ReceptDAO extends GenericDAOImpl<Recept, Integer> {
    public ReceptDAO() {
        super(Recept.class);
    }

    /**
     * Najde recepty vydané po určitém datu
     */
    public List<Recept> findAfterDate(OffsetDateTime date) {
        TypedQuery<Recept> q = em.createQuery(
                "SELECT r FROM Recept r WHERE r.idNavsteva.datum >= :date", Recept.class);
        q.setParameter("date", date);
        return q.getResultList();
    }

    /**
     * Najde recepty pro konkrétní návštěvu
     */
    public List<Recept> findByNavstevaId(int navstevaId) {
        TypedQuery<Recept> q = em.createQuery(
                "SELECT r FROM Recept r WHERE r.idNavsteva.id = :nid", Recept.class);
        q.setParameter("nid", navstevaId);
        return q.getResultList();
    }
}
