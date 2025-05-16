package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.model.Navsteva;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.time.OffsetDateTime;

public class NavstevaDAO extends GenericDAOImpl<Navsteva, Integer> {
    public NavstevaDAO() {
        super(Navsteva.class);
    }

    /**
     * Najde návštěvy podle typu
     */
    public List<Navsteva> findByType(String typ) {
        TypedQuery<Navsteva> q = em.createQuery(
                "SELECT n FROM Navsteva n WHERE n.typ = :typ", Navsteva.class);
        q.setParameter("typ", typ);
        return q.getResultList();
    }

    /**
     * Najde návštěvy mezi dvěma daty
     */
    public List<Navsteva> findBetweenDates(OffsetDateTime start, OffsetDateTime end) {
        TypedQuery<Navsteva> q = em.createQuery(
                "SELECT n FROM Navsteva n WHERE n.datum BETWEEN :start AND :end", Navsteva.class);
        q.setParameter("start", start);
        q.setParameter("end", end);
        return q.getResultList();
    }
}