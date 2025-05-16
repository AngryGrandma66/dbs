package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Rel_recept_lekar\"")
public class RelReceptLekar {
    @EmbeddedId
    private RelReceptLekarId id;

    @MapsId("idRecept")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recept", nullable = false)
    private Recept idRecept;

    @MapsId("idLekar")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lekar", nullable = false)
    private Lekar idLekar;

    public RelReceptLekarId getId() {
        return id;
    }

    public void setId(RelReceptLekarId id) {
        this.id = id;
    }

    public Recept getIdRecept() {
        return idRecept;
    }

    public void setIdRecept(Recept idRecept) {
        this.idRecept = idRecept;
    }

    public Lekar getIdLekar() {
        return idLekar;
    }

    public void setIdLekar(Lekar idLekar) {
        this.idLekar = idLekar;
    }

}