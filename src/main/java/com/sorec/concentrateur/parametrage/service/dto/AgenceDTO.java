package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Agence} entity.
 */
public class AgenceDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idagence;

    @Size(max = 254)
    private String codeagence;

    private Integer numero;

    @Size(max = 254)
    private String nom;

    @Size(max = 254)
    private String adresse;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdagence() {
        return idagence;
    }

    public void setIdagence(Integer idagence) {
        this.idagence = idagence;
    }

    public String getCodeagence() {
        return codeagence;
    }

    public void setCodeagence(String codeagence) {
        this.codeagence = codeagence;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AgenceDTO)) {
            return false;
        }

        return id != null && id.equals(((AgenceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AgenceDTO{" +
            "id=" + getId() +
            ", idagence=" + getIdagence() +
            ", codeagence='" + getCodeagence() + "'" +
            ", numero=" + getNumero() +
            ", nom='" + getNom() + "'" +
            ", adresse='" + getAdresse() + "'" +
            "}";
    }
}
