package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"Lekar\"")
public class Lekar {
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

    @Column(name = "specializace", nullable = false, length = 50)
    private String specializace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nadrizeny")
    private Lekar idNadrizeny;

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

    public String getSpecializace() {
        return specializace;
    }

    public void setSpecializace(String specializace) {
        this.specializace = specializace;
    }

    public Lekar getIdNadrizeny() {
        return idNadrizeny;
    }

    public void setIdNadrizeny(Lekar idNadrizeny) {
        this.idNadrizeny = idNadrizeny;
    }

}