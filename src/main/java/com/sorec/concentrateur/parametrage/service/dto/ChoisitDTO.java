package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Choisit} entity.
 */
public class ChoisitDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idproduit;


    private Long idattributaireId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public Long getIdattributaireId() {
        return idattributaireId;
    }

    public void setIdattributaireId(Long attributaireId) {
        this.idattributaireId = attributaireId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChoisitDTO)) {
            return false;
        }

        return id != null && id.equals(((ChoisitDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ChoisitDTO{" +
            "id=" + getId() +
            ", idproduit=" + getIdproduit() +
            ", idattributaireId=" + getIdattributaireId() +
            "}";
    }
}
