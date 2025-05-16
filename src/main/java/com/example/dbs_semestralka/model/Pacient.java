package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Pacient\"")
public class Pacient extends Osoba {

    @Column(name = "cislo_pojistence", nullable = false, length = 10)
    private String cisloPojistence;

    @Column(name = "rodne_cislo", length = 11)
    private String rodneCislo;

    @OneToMany(mappedBy = "idPacient", fetch = FetchType.LAZY)
    private Set<Navsteva> navstevy = new HashSet<>();

    public Set<Navsteva> getNavstevy() { return navstevy; }
    public void setNavstevy(Set<Navsteva> navstevy) { this.navstevy = navstevy; }
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