package com.example.dbs_semestralka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.util.Objects;

@Embeddable
public class RelLekarNavstevaId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 3147892384372971190L;
    @Column(name = "id_lekar", nullable = false)
    private Integer idLekar;

    @Column(name = "id_navsteva", nullable = false)
    private Integer idNavsteva;

    public Integer getIdLekar() {
        return idLekar;
    }

    public void setIdLekar(Integer idLekar) {
        this.idLekar = idLekar;
    }

    public Integer getIdNavsteva() {
        return idNavsteva;
    }

    public void setIdNavsteva(Integer idNavsteva) {
        this.idNavsteva = idNavsteva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelLekarNavstevaId entity = (RelLekarNavstevaId) o;
        return Objects.equals(this.idLekar, entity.idLekar) &&
                Objects.equals(this.idNavsteva, entity.idNavsteva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLekar, idNavsteva);
    }

}