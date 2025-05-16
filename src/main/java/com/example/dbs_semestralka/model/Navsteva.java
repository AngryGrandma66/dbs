package com.example.dbs_semestralka.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Navsteva\"")
public class Navsteva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "datum", nullable = false)
    private OffsetDateTime datum;

    @Column(name = "typ", nullable = false, length = 50)
    private String typ;

    @Lob
    @Column(name = "lekarska_zprava")
    private String lekarskaZprava;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pacient", nullable = false)
    private com.example.dbs_semestralka.model.Pacient idPacient;

    @Column(name = "cas_upravy")
    private Instant casUpravy;


    @ManyToMany
    @JoinTable(
            name = "\"Rel_lekar_navsteva\"",
            joinColumns = @JoinColumn(name = "id_navsteva"),
            inverseJoinColumns = @JoinColumn(name = "id_lekar")
    )
    private Set<Lekar> lekari = new HashSet<>();

    public Set<Lekar> getLekari() {
        return lekari;
    }
    public void setLekari(Set<Lekar> lekari) {
        this.lekari = lekari;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OffsetDateTime getDatum() {
        return datum;
    }

    public void setDatum(OffsetDateTime datum) {
        this.datum = datum;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getLekarskaZprava() {
        return lekarskaZprava;
    }

    public void setLekarskaZprava(String lekarskaZprava) {
        this.lekarskaZprava = lekarskaZprava;
    }

    public com.example.dbs_semestralka.model.Pacient getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(com.example.dbs_semestralka.model.Pacient idPacient) {
        this.idPacient = idPacient;
    }

    public Instant getCasUpravy() {
        return casUpravy;
    }

    public void setCasUpravy(Instant casUpravy) {
        this.casUpravy = casUpravy;
    }

}