package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.dto.ReceptLatestRow;
import com.example.dbs_semestralka.model.Recept;
import java.util.List;
import java.time.OffsetDateTime;

public class ReceptDAO extends GenericDAOImpl<Recept, Integer> {
    public ReceptDAO() {
        super(Recept.class);
    }

    public List<ReceptLatestRow> findLatestRecepty(OffsetDateTime after) {
        String jpql =
                "SELECT new com.example.dbs_semestralka.dto.ReceptLatestRow(" +
                        "   r.id, r.nazevLeku, r.davkovani, n.datum" +
                        ") " +
                        "FROM Recept r " +
                        "  JOIN r.idNavsteva n " +
                        "WHERE n.datum >= :after " +
                        "ORDER BY n.datum DESC";

        return em.createQuery(jpql, ReceptLatestRow.class)
                .setParameter("after", after)
                .setMaxResults(10)
                .getResultList();
    }

}
