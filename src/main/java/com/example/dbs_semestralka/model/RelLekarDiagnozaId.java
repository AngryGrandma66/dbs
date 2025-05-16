package com.example.dbs_semestralka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.util.Objects;

@Embeddable
public class RelLekarDiagnozaId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = -990589017386698620L;
    @Column(name = "id_diagnoza", nullable = false)
    private Integer idDiagnoza;

    @Column(name = "id_lekar", nullable = false)
    private Integer idLekar;

    public Integer getIdDiagnoza() {
        return idDiagnoza;
    }

    public void setIdDiagnoza(Integer idDiagnoza) {
        this.idDiagnoza = idDiagnoza;
    }

    public Integer getIdLekar() {
        return idLekar;
    }

    public void setIdLekar(Integer idLekar) {
        this.idLekar = idLekar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelLekarDiagnozaId entity = (RelLekarDiagnozaId) o;
        return Objects.equals(this.idDiagnoza, entity.idDiagnoza) &&
                Objects.equals(this.idLekar, entity.idLekar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiagnoza, idLekar);
    }

}