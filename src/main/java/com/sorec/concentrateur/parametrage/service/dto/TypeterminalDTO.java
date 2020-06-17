package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Typeterminal} entity.
 */
public class TypeterminalDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idtypeterminal;

    @Size(max = 254)
    private String codetypeterminal;

    @Size(max = 254)
    private String libelle;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdtypeterminal() {
        return idtypeterminal;
    }

    public void setIdtypeterminal(Integer idtypeterminal) {
        this.idtypeterminal = idtypeterminal;
    }

    public String getCodetypeterminal() {
        return codetypeterminal;
    }

    public void setCodetypeterminal(String codetypeterminal) {
        this.codetypeterminal = codetypeterminal;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypeterminalDTO)) {
            return false;
        }

        return id != null && id.equals(((TypeterminalDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TypeterminalDTO{" +
            "id=" + getId() +
            ", idtypeterminal=" + getIdtypeterminal() +
            ", codetypeterminal='" + getCodetypeterminal() + "'" +
            ", libelle='" + getLibelle() + "'" +
            "}";
    }
}
