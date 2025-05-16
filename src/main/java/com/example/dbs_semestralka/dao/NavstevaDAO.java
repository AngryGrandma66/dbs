package com.example.dbs_semestralka.dao;

import com.example.dbs_semestralka.dto.NavstevyPacientLekarRow;
import com.example.dbs_semestralka.dto.PacientiNavstevyRow;
import com.example.dbs_semestralka.model.Navsteva;

import java.time.LocalDate;
import java.util.List;

public class NavstevaDAO extends GenericDAOImpl<Navsteva, Integer> {
    public NavstevaDAO() {
        super(Navsteva.class);
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
    public List<NavstevyPacientLekarRow> findKontrolniNavstevy(String typ) {
        String jpql =
                "SELECT new com.example.dbs_semestralka.dto.NavstevyPacientLekarRow(" +
                        "   n.id, n.datum, p.jmeno, p.prijmeni, l.jmeno, l.prijmeni" +
                        ") " +
                        "FROM Navsteva n " +
                        "   JOIN n.idPacient p " +
                        "   JOIN n.lekari      l " +
                        "WHERE n.typ = :typ " +
                        "ORDER BY n.datum DESC";

        return em.createQuery(jpql, NavstevyPacientLekarRow.class)
                .setParameter("typ", typ)
                .getResultList();
    }
}