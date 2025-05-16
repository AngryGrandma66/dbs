package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Recept\"")
public class Recept {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "davkovani", nullable = false, length = 150)
    private String davkovani;

    @Column(name = "nazev_leku", nullable = false)
    private String nazevLeku;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_navsteva", nullable = false)
    private Navsteva idNavsteva;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDavkovani() {
        return davkovani;
    }

    public void setDavkovani(String davkovani) {
        this.davkovani = davkovani;
    }

    public String getNazevLeku() {
        return nazevLeku;
    }

    public void setNazevLeku(String nazevLeku) {
        this.nazevLeku = nazevLeku;
    }

    public Navsteva getIdNavsteva() {
        return idNavsteva;
    }

    public void setIdNavsteva(Navsteva idNavsteva) {
        this.idNavsteva = idNavsteva;
    }

}