package com.example.dbs_semestralka.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Integer id;

    @Column(name = "telefon", nullable = false, length = 15)
    protected String telefon;

    @Column(name = "adresa", nullable = false, length = 150)
    protected String adresa;

    @Column(name = "datum_narozeni", nullable = false)
    protected LocalDate datumNarozeni;

    @Column(name = "prijmeni", nullable = false, length = 50)
    protected String prijmeni;

    @Column(name = "jmeno", nullable = false, length = 50)
    protected String jmeno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
}
