package com.example.dbs_semestralka.dto;

public class PacientRokRow {
    private final String jmeno;
    private final String prijmeni;
    private final String cisloPojistence;

    public PacientRokRow(String jmeno, String prijmeni, String cisloPojistence) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.cisloPojistence = cisloPojistence;
    }

    public String getJmeno() { return jmeno; }
    public String getPrijmeni() { return prijmeni; }
    public String getCisloPojistence() { return cisloPojistence; }
}
