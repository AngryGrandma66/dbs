package com.example.dbs_semestralka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "\"Pacient\"")
public class Pacient {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "telefon", nullable = false, length = 15)
    private String telefon;

    @Column(name = "adresa", nullable = false, length = 150)
    private String adresa;

    @Column(name = "datum_narozeni", nullable = false)
    private LocalDate datumNarozeni;

    @Column(name = "prijmeni", nullable = false, length = 50)
    private String prijmeni;

    @Column(name = "jmeno", nullable = false, length = 50)
    private String jmeno;

    @Column(name = "cislo_pojistence", nullable = false, length = 10)
    private String cisloPojistence;

    @Column(name = "rodne_cislo", length = 11)
    private String rodneCislo;

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

    public String getCisloPojistence() {
        return cisloPojistence;
    }

    public void setCisloPojistence(String cisloPojistence) {
        this.cisloPojistence = cisloPojistence;
    }

    public String getRodneCislo() {
        return rodneCislo;
    }

    public void setRodneCislo(String rodneCislo) {
        this.rodneCislo = rodneCislo;
    }

}