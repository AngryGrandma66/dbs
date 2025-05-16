package com.example.dbs_semestralka.service;

import com.example.dbs_semestralka.dao.*;
import com.example.dbs_semestralka.model.*;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Servisní vrstva pro základní zápisové operace.
 */
public class NemocniceService {

    private final PacientDAO pacientDAO     = new PacientDAO();
    private final NavstevaDAO navstevaDAO = new NavstevaDAO();
    private final LekarDAO lekarDAO       = new LekarDAO();
    private final ReceptDAO receptDAO     = new ReceptDAO();
    private final DiagnozaDAO diagnozaDAO = new DiagnozaDAO();

    /** 1) Registrace nového pacienta */
    public void registrujPacienta(Pacient p) {
        pacientDAO.persist(p);
    }

    /** 2) Vytvoření návštěvy pro pacienta */
    public void vytvorNavstevu(Navsteva n) {
        navstevaDAO.persist(n);
    }

    /** 3) Přiřazení lékaře k existující návštěvě */
    public void pridejLekareNaNavstevu(int idNavstevy, int idLekare) {
        Navsteva n = navstevaDAO.findById(idNavstevy);
        Lekar l    = lekarDAO.findById(idLekare);
        n.getLekari().add(l);
        navstevaDAO.update(n);
    }

    /** 4) Aktualizace specializace lékaře a popisu diagnózy (CP-4) */
    public void aktualizujLekareADiagnostiku() {
        Lekar l = lekarDAO.findById(1);
        l.setSpecializace("Tralalero Tralala");
        lekarDAO.update(l);

        Diagnoza d = diagnozaDAO.findByPatientId(5);
        d.setPopis("Balerina Capuccina");
        diagnozaDAO.update(d);
    }

    /** 5) Vystavení nového receptu */
    public void vytvorRecept(Recept r) {
        receptDAO.persist(r);
    }

    /** 6) Přidání nové diagnózy pro pacienta */
    public void pridejDiagnozu(Diagnoza d) {
        diagnozaDAO.persist(d);
    }

    /** 7) Získání všech návštěv pacienta */
    public List<Navsteva> getNavstevyPacienta(int pacientId) {
        return navstevaDAO.findBetweenDates(
                OffsetDateTime.now().minusYears(1), OffsetDateTime.now());
    }

    /** 8) Získání lékařů podle specializace */
    public List<Lekar> getLekariPodleSpecializace(String spec) {
        return lekarDAO.findBySpecialization(spec);
    }
    public Pacient najdiPacienta(int id) {
        return pacientDAO.findById(id);
    }

    /** Pomocná metoda: najdi návštěvu podle ID */
    public Navsteva najdiNavstevu(int id) {
        return navstevaDAO.findById(id);
    }
}