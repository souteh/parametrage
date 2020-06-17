package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Statutticketenum} entity.
 */
public class StatutticketenumDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String valide;

    @Size(max = 254)
    private String annule;

    @Size(max = 254)
    private String paye;

    @Size(max = 254)
    private String rembourse;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValide() {
        return valide;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public String getAnnule() {
        return annule;
    }

    public void setAnnule(String annule) {
        this.annule = annule;
    }

    public String getPaye() {
        return paye;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }

    public String getRembourse() {
        return rembourse;
    }

    public void setRembourse(String rembourse) {
        this.rembourse = rembourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StatutticketenumDTO)) {
            return false;
        }

        return id != null && id.equals(((StatutticketenumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StatutticketenumDTO{" +
            "id=" + getId() +
            ", valide='" + getValide() + "'" +
            ", annule='" + getAnnule() + "'" +
            ", paye='" + getPaye() + "'" +
            ", rembourse='" + getRembourse() + "'" +
            "}";
    }
}
