package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.model.Lekar;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class LekarDAO extends GenericDAOImpl<Lekar, Integer> {
    public LekarDAO() {
        super(Lekar.class);
    }

    /**
     * Najde lékaře podle specializace
     */
    public List<Lekar> findBySpecialization(String spec) {
        TypedQuery<Lekar> q = em.createQuery(
                "SELECT l FROM Lekar l WHERE l.specializace = :spec", Lekar.class);
        q.setParameter("spec", spec);
        return q.getResultList();
    }

    /**
     * Najde nadřízené lékaře (ti, kteří mají podřízené)
     */
    public List<Lekar> findSupervisors() {
        TypedQuery<Lekar> q = em.createQuery(
                "SELECT DISTINCT l.idNadrizeny FROM Lekar l WHERE l.idNadrizeny IS NOT NULL", Lekar.class);
        return q.getResultList();
    }
}
