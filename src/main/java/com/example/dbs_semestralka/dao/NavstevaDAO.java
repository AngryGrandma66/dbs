package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.dto.PacientiNavstevyRow;
import com.example.dbs_semestralka.model.Navsteva;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
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
    public List<PacientiNavstevyRow> findPacientiNavstevy(LocalDate after) {
        String jpql =
                "SELECT new com.example.dbs_semestralka.dto.PacientiNavstevyRow(" +
                        "   p.jmeno, p.prijmeni, p.datumNarozeni, n.id, n.datum" +
                        ") " +
                        "FROM Pacient p " +
                        "LEFT JOIN p.navstevy n " +
                        "WHERE p.datumNarozeni > :after";

        return em.createQuery(jpql, PacientiNavstevyRow.class)
                .setParameter("after", after)
                .getResultList();
    }
}