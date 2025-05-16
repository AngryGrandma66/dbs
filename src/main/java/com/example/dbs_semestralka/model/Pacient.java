package com.example.dbs_semestralka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "\"Pacient\"")
public class Pacient extends Osoba {

    @Column(name = "cislo_pojistence", nullable = false, length = 10)
    private String cisloPojistence;

    @Column(name = "rodne_cislo", length = 11)
    private String rodneCislo;


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