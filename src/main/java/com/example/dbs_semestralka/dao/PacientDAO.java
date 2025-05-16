package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.model.Pacient;
import jakarta.persistence.TypedQuery;

import java.time.OffsetDateTime;
import java.util.List;

public class PacientDAO extends GenericDAOImpl<Pacient, Integer> {
    public PacientDAO() {
        super(Pacient.class);
    }

    /**
     * Parametrizovaný dotaz: najde pacienta podle čísla pojištěnce
     */
    public Pacient findByCisloPojistence(String cislo) {
        TypedQuery<Pacient> q = em.createQuery(
                "SELECT p FROM Pacient p WHERE p.cisloPojistence = :cislo", Pacient.class);
        q.setParameter("cislo", cislo);
        return q.getResultStream().findFirst().orElse(null);
    }
    /**
     * Vrátí seznam pacientů narozených mezi dvěma daty
     */
    public List<Pacient> findByBirthDateRange(OffsetDateTime from, OffsetDateTime to) {
        TypedQuery<Pacient> q = em.createQuery(
                "SELECT p FROM Pacient p WHERE p.datumNarozeni BETWEEN :from AND :to", Pacient.class);
        q.setParameter("from", from.toLocalDate());
        q.setParameter("to", to.toLocalDate());
        return q.getResultList();
    }
}