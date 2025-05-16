package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Rel_lekar_navsteva\"")
public class RelLekarNavsteva {
    @EmbeddedId
    private RelLekarNavstevaId id;

    @MapsId("idLekar")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lekar", nullable = false)
    private Lekar idLekar;

    @MapsId("idNavsteva")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_navsteva", nullable = false)
    private Navsteva idNavsteva;

    public RelLekarNavstevaId getId() {
        return id;
    }

    public void setId(RelLekarNavstevaId id) {
        this.id = id;
    }

    public Lekar getIdLekar() {
        return idLekar;
    }

    public void setIdLekar(Lekar idLekar) {
        this.idLekar = idLekar;
    }

    public Navsteva getIdNavsteva() {
        return idNavsteva;
    }

    public void setIdNavsteva(Navsteva idNavsteva) {
        this.idNavsteva = idNavsteva;
    }

}