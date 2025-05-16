package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.model.Diagnoza;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class DiagnozaDAO extends GenericDAOImpl<Diagnoza, Integer> {
    public DiagnozaDAO() {
        super(Diagnoza.class);
    }

    /**
     * Najde diagnózu podle pacienta.
     */
    public Diagnoza findByPatientId(Integer pacientId) {
        TypedQuery<Diagnoza> q = em.createQuery(
                "SELECT d FROM Diagnoza d WHERE d.idPacient.id = :pid", Diagnoza.class);
        q.setParameter("pid", pacientId);
        return q.getResultStream().findFirst().orElse(null);
    }

    /**
     * Najde všechny diagnózy určitého kódu
     */
    public List<Diagnoza> findByCode(String code) {
        TypedQuery<Diagnoza> q = em.createQuery(
                "SELECT d FROM Diagnoza d WHERE d.kod = :code", Diagnoza.class);
        q.setParameter("code", code);
        return q.getResultList();
    }
}
