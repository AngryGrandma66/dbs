package com.example.dbs_semestralka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.util.Objects;

@Embeddable
public class RelReceptLekarId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 5862716114417021701L;
    @Column(name = "id_recept", nullable = false)
    private Integer idRecept;

    @Column(name = "id_lekar", nullable = false)
    private Integer idLekar;

    public Integer getIdRecept() {
        return idRecept;
    }

    public void setIdRecept(Integer idRecept) {
        this.idRecept = idRecept;
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
        RelReceptLekarId entity = (RelReceptLekarId) o;
        return Objects.equals(this.idRecept, entity.idRecept) &&
                Objects.equals(this.idLekar, entity.idLekar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecept, idLekar);
    }

}