package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.dto.PacientNavstevCountRow;
import com.example.dbs_semestralka.dto.PacientRokRow;
import com.example.dbs_semestralka.model.Pacient;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PacientDAO extends GenericDAOImpl<Pacient, Integer> {
    public PacientDAO() {
        super(Pacient.class);
    }


    public List<PacientNavstevCountRow> findPacientiWithMinNavstev(long minNavstev) {
        String jpql =
                "SELECT new com.example.dbs_semestralka.dto.PacientNavstevCountRow(" +
                        "   p.jmeno, p.prijmeni, COUNT(n) " +
                        ") " +
                        "FROM Pacient p " +
                        "   LEFT JOIN p.navstevy n " +
                        "GROUP BY p.id, p.jmeno, p.prijmeni " +
                        "HAVING COUNT(n) >= :minNavstev " +
                        "ORDER BY COUNT(n) DESC";

        TypedQuery<PacientNavstevCountRow> q = em.createQuery(jpql, PacientNavstevCountRow.class);
        q.setParameter("minNavstev", minNavstev);
        return q.getResultList();
    }



    public List<PacientRokRow> findPacientiByYear(int year) {
        String jpql =
                "SELECT DISTINCT new com.example.dbs_semestralka.dto.PacientRokRow(" +
                        "   p.jmeno, p.prijmeni, p.cisloPojistence" +
                        ") " +
                        "FROM Pacient p " +
                        "WHERE EXISTS (" +
                        "    SELECT 1 FROM Diagnoza d " +
                        "    WHERE d.idPacient = p AND YEAR(d.datum) = :year" +
                        ") " +
                        "OR EXISTS (" +
                        "    SELECT 1 FROM Navsteva n " +
                        "    WHERE n.idPacient  = p AND YEAR(n.datum) = :year" +
                        ") " +
                        "ORDER BY p.prijmeni, p.jmeno";

        return em.createQuery(jpql, PacientRokRow.class)
                .setParameter("year", year)
                .getResultList();

    }
}