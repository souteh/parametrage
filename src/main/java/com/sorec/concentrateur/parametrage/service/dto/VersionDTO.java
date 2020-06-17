package com.sorec.concentrateur.parametrage.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Version} entity.
 */
public class VersionDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idversion;

    @Size(max = 254)
    private String refversion;

    @Size(max = 254)
    private String libelle;

    private Instant date;

    @Size(max = 254)
    private String fichier;


    private Long idtypeterminalId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdversion() {
        return idversion;
    }

    public void setIdversion(Integer idversion) {
        this.idversion = idversion;
    }

    public String getRefversion() {
        return refversion;
    }

    public void setRefversion(String refversion) {
        this.refversion = refversion;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public Long getIdtypeterminalId() {
        return idtypeterminalId;
    }

    public void setIdtypeterminalId(Long typeterminalId) {
        this.idtypeterminalId = typeterminalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VersionDTO)) {
            return false;
        }

        return id != null && id.equals(((VersionDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VersionDTO{" +
            "id=" + getId() +
            ", idversion=" + getIdversion() +
            ", refversion='" + getRefversion() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", date='" + getDate() + "'" +
            ", fichier='" + getFichier() + "'" +
            ", idtypeterminalId=" + getIdtypeterminalId() +
            "}";
    }
}
