package com.example.dbs_semestralka.service;

import com.example.dbs_semestralka.dao.*;
import com.example.dbs_semestralka.dto.*;
import com.example.dbs_semestralka.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class NemocniceService {

    private final PacientDAO pacientDAO = new PacientDAO();
    private final NavstevaDAO navstevaDAO = new NavstevaDAO();
    private final LekarDAO lekarDAO = new LekarDAO();
    private final ReceptDAO receptDAO = new ReceptDAO();
    private final DiagnozaDAO diagnozaDAO = new DiagnozaDAO();

    public void registrujPacienta(Pacient p) {
        pacientDAO.persist(p);
    }

    public void vytvorNavstevu(Navsteva n) {
        navstevaDAO.persist(n);
    }

    public void pridejLekareNaNavstevu(int idNavstevy, int idLekare) {
        Navsteva n = navstevaDAO.findById(idNavstevy);
        Lekar l = lekarDAO.findById(idLekare);
        n.getLekari().add(l);
        navstevaDAO.update(n);
    }

    public void vytvorRecept(Recept r) {
        receptDAO.persist(r);
    }

    public Pacient najdiPacienta(int id) {
        return pacientDAO.findById(id);
    }

    public Navsteva najdiNavstevu(int id) {
        return navstevaDAO.findById(id);
    }

    public List<PacientiNavstevyRow> getPacientiNavstevy(LocalDate after) {
        return navstevaDAO.findPacientiNavstevy(after);
    }

    public List<NavstevyPacientLekarRow> getKontrolniNavstevy() {
        return navstevaDAO.findKontrolniNavstevy("kontrola");
    }

    public List<PacientNavstevCountRow> getPacientiSMinNavstev(long minNavstev) {
        return pacientDAO.findPacientiWithMinNavstev(minNavstev);
    }

    public List<ReceptLatestRow> getLatestRecepty(OffsetDateTime after) {
        return receptDAO.findLatestRecepty(after);
    }


    public List<PacientRokRow> getPacientiByYear(int year) {
        return pacientDAO.findPacientiByYear(year);
    }

    public List<LekarNavstevyRow> getLekariNavstevyNadPrumerem() {
        return lekarDAO.findLekariNavstevyNadPrumerem();
    }

    public List<DiagnostikaPacientKardiologieRow> getPacientiDiagnozyKardiologie() {
        return diagnozaDAO.findPacientiDiagnozyKardiologie(
                "kardiologie",
                LocalDate.of(2024, 1, 1),
                5,
                0
        );
    }

    public void aktualizujLekareADiagnostikuTransactional() {
        EntityManager em = JPAUtil.createEntityManager();

        EntityTransaction  tx = em.getTransaction();
        try (em) {
            LekarDAO lekarDAO2 = new LekarDAO(em);
            DiagnozaDAO diagDAO = new DiagnozaDAO(em);
            tx.begin();
            lekarDAO2.updateSpecializace(1, "Tralalero Tralala");
            diagDAO.updatePopisByPacient(5, "Balerina Capuccina");
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }
}