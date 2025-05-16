package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"Diagnoza\"")
public class Diagnoza {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "popis", nullable = false)
    private String popis;

    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    @Column(name = "kod", nullable = false, length = 10)
    private String kod;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pacient", nullable = false)
    private com.example.dbs_semestralka.model.Pacient idPacient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public com.example.dbs_semestralka.model.Pacient getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(com.example.dbs_semestralka.model.Pacient idPacient) {
        this.idPacient = idPacient;
    }

}