package com.sorec.concentrateur.parametrage.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Association12} entity.
 */
public class Association12DTO implements Serializable {
    
    private Long id;

    private Long identifiantconc;


    private Long idId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdentifiantconc() {
        return identifiantconc;
    }

    public void setIdentifiantconc(Long identifiantconc) {
        this.identifiantconc = identifiantconc;
    }

    public Long getIdId() {
        return idId;
    }

    public void setIdId(Long clientglentityId) {
        this.idId = clientglentityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Association12DTO)) {
            return false;
        }

        return id != null && id.equals(((Association12DTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Association12DTO{" +
            "id=" + getId() +
            ", identifiantconc=" + getIdentifiantconc() +
            ", idId=" + getIdId() +
            "}";
    }
}
