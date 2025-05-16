package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.dto.LekarNavstevyRow;
import com.example.dbs_semestralka.model.Lekar;
import jakarta.persistence.EntityManager;
import java.util.List;

public class LekarDAO extends GenericDAOImpl<Lekar, Integer> {
    public LekarDAO() {
        super(Lekar.class);
    }
    public LekarDAO(EntityManager em) { super(Lekar.class, em); }


    public List<LekarNavstevyRow> findLekariNavstevyNadPrumerem() {
        List<Long> counts = em.createQuery(
                        "SELECT COUNT(r) FROM RelLekarNavsteva r GROUP BY r.idLekar", Long.class)
                .getResultList();

        double avg = counts.stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0);
        long threshold = (long) Math.ceil(avg);

        String jpql =
                "SELECT new com.example.dbs_semestralka.dto.LekarNavstevyRow(" +
                        "   l.jmeno, l.prijmeni, COUNT(r)" +
                        ") " +
                        "FROM RelLekarNavsteva r " +
                        " JOIN r.idLekar l " +
                        "GROUP BY l.id, l.jmeno, l.prijmeni " +
                        "HAVING COUNT(r) > :threshold " +
                        "ORDER BY COUNT(r) DESC";

        return em.createQuery(jpql, LekarNavstevyRow.class)
                .setParameter("threshold", threshold)
                .getResultList();
    }
    public int updateSpecializace(int lekarId, String newSpec) {
        return em.createQuery(
                        "UPDATE Lekar l SET l.specializace = :spec WHERE l.id = :lid")
                .setParameter("spec", newSpec)
                .setParameter("lid", lekarId)
                .executeUpdate();
    }
}
