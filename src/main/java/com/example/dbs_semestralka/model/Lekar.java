package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"Lekar\"")
public class Lekar extends Osoba {


    @Column(name = "specializace", nullable = false, length = 50)
    private String specializace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nadrizeny")
    private Lekar idNadrizeny;


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