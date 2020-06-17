package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Pdventity} entity.
 */
public class PdventityDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Long idpdv;

    @Size(max = 254)
    private String referencepdv;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdpdv() {
        return idpdv;
    }

    public void setIdpdv(Long idpdv) {
        this.idpdv = idpdv;
    }

    public String getReferencepdv() {
        return referencepdv;
    }

    public void setReferencepdv(String referencepdv) {
        this.referencepdv = referencepdv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PdventityDTO)) {
            return false;
        }

        return id != null && id.equals(((PdventityDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PdventityDTO{" +
            "id=" + getId() +
            ", idpdv=" + getIdpdv() +
            ", referencepdv='" + getReferencepdv() + "'" +
            "}";
    }
}
