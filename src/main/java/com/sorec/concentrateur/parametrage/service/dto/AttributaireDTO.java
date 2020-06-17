package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Attributaire} entity.
 */
public class AttributaireDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idattributaire;

    @Size(max = 254)
    private String libelle;

    @Size(max = 254)
    private String codeattributaire;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdattributaire() {
        return idattributaire;
    }

    public void setIdattributaire(Integer idattributaire) {
        this.idattributaire = idattributaire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeattributaire() {
        return codeattributaire;
    }

    public void setCodeattributaire(String codeattributaire) {
        this.codeattributaire = codeattributaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AttributaireDTO)) {
            return false;
        }

        return id != null && id.equals(((AttributaireDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AttributaireDTO{" +
            "id=" + getId() +
            ", idattributaire=" + getIdattributaire() +
            ", libelle='" + getLibelle() + "'" +
            ", codeattributaire='" + getCodeattributaire() + "'" +
            "}";
    }
}
