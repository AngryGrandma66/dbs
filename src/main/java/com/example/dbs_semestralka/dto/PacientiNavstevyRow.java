package com.example.dbs_semestralka.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class PacientiNavstevyRow {
    private final String jmeno;
    private final String prijmeni;
    private final LocalDate datumNarozeni;
    private final Integer navstevaId;
    private final OffsetDateTime datumNavstevy;

    public PacientiNavstevyRow(String jmeno, String prijmeni,
                               LocalDate datumNarozeni,
                               Integer navstevaId,
                               OffsetDateTime datumNavstevy) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.navstevaId = navstevaId;
        this.datumNavstevy = datumNavstevy;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public Integer getNavstevaId() {
        return navstevaId;
    }

    public OffsetDateTime getDatumNavstevy() {
        return datumNavstevy;
    }
}