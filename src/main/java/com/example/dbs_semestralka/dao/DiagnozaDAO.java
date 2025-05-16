package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.dto.DiagnostikaPacientKardiologieRow;
import com.example.dbs_semestralka.model.Diagnoza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class DiagnozaDAO extends GenericDAOImpl<Diagnoza, Integer> {
    public DiagnozaDAO() {
        super(Diagnoza.class);
    }
    public DiagnozaDAO(EntityManager em) { super(Diagnoza.class, em); }

    public List<DiagnostikaPacientKardiologieRow> findPacientiDiagnozyKardiologie(
            String specializace, LocalDate since, int limit, int offset) {
        String jpql =
                "SELECT new com.example.dbs_semestralka.dto.DiagnostikaPacientKardiologieRow(" +
                        "   p.jmeno, p.prijmeni, d.kod, d.popis, l.jmeno, l.prijmeni" +
                        ") " +
                        "FROM RelLekarDiagnoza rld " +
                        "  JOIN rld.idDiagnoza d " +
                        "  JOIN d.idPacient p " +
                        "  JOIN rld.idLekar l " +
                        "WHERE l.specializace = :spec " +
                        "  AND d.datum >= :since " +
                        "ORDER BY d.datum DESC";

        TypedQuery<DiagnostikaPacientKardiologieRow> q = em.createQuery(
                jpql, DiagnostikaPacientKardiologieRow.class);
        q.setParameter("spec", specializace);
        q.setParameter("since", since);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        return q.getResultList();
    }
    public int updatePopisByPacient(int pacientId, String newDesc) {
        return em.createQuery(
                        "UPDATE Diagnoza d SET d.popis = :desc WHERE d.idPacient.id = :pid")
                .setParameter("desc", newDesc)
                .setParameter("pid", pacientId)
                .executeUpdate();
    }
}
