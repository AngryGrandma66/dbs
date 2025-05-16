package com.example.dbs_semestralka.dto;

public class PacientNavstevCountRow {
    private final String jmeno;
    private final String prijmeni;
    private final Long pocetNavstev;

    public PacientNavstevCountRow(String jmeno, String prijmeni, Long pocetNavstev) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.pocetNavstev = pocetNavstev;
    }

    public String getJmeno()       { return jmeno; }
    public String getPrijmeni()    { return prijmeni; }
    public Long   getPocetNavstev(){ return pocetNavstev; }
}