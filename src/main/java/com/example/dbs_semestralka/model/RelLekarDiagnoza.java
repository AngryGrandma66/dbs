package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Rel_lekar_diagnoza\"")
public class RelLekarDiagnoza {
    @EmbeddedId
    private RelLekarDiagnozaId id;

    @MapsId("idDiagnoza")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_diagnoza", nullable = false)
    private Diagnoza idDiagnoza;

    @MapsId("idLekar")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lekar", nullable = false)
    private Lekar idLekar;

    public RelLekarDiagnozaId getId() {
        return id;
    }

    public void setId(RelLekarDiagnozaId id) {
        this.id = id;
    }

    public Diagnoza getIdDiagnoza() {
        return idDiagnoza;
    }

    public void setIdDiagnoza(Diagnoza idDiagnoza) {
        this.idDiagnoza = idDiagnoza;
    }

    public Lekar getIdLekar() {
        return idLekar;
    }

    public void setIdLekar(Lekar idLekar) {
        this.idLekar = idLekar;
    }

}