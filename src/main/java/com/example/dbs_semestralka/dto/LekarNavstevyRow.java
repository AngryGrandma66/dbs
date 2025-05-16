package com.example.dbs_semestralka.dto;

public class LekarNavstevyRow {
    private final String jmeno;
    private final String prijmeni;
    private final long pocetNavstev;

    public LekarNavstevyRow(String jmeno, String prijmeni, long pocetNavstev) {
        this.jmeno         = jmeno;
        this.prijmeni      = prijmeni;
        this.pocetNavstev  = pocetNavstev;
    }

    public String getJmeno()         { return jmeno; }
    public String getPrijmeni()      { return prijmeni; }
    public long   getPocetNavstev()  { return pocetNavstev; }
}