package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Pdv} entity.
 */
public class PdvDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer numero;

    @Size(max = 64)
    private String agence;

    @Size(max = 64)
    private String designation;

    @Size(max = 64)
    private String ville;

    @Size(max = 64)
    private String statut;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PdvDTO)) {
            return false;
        }

        return id != null && id.equals(((PdvDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PdvDTO{" +
            "id=" + getId() +
            ", numero=" + getNumero() +
            ", agence='" + getAgence() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", ville='" + getVille() + "'" +
            ", statut='" + getStatut() + "'" +
            "}";
    }
}
