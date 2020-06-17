package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Typeoperationenum} entity.
 */
public class TypeoperationenumDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String pari;

    @Size(max = 254)
    private String annulation;

    @Size(max = 254)
    private String paiement;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPari() {
        return pari;
    }

    public void setPari(String pari) {
        this.pari = pari;
    }

    public String getAnnulation() {
        return annulation;
    }

    public void setAnnulation(String annulation) {
        this.annulation = annulation;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypeoperationenumDTO)) {
            return false;
        }

        return id != null && id.equals(((TypeoperationenumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TypeoperationenumDTO{" +
            "id=" + getId() +
            ", pari='" + getPari() + "'" +
            ", annulation='" + getAnnulation() + "'" +
            ", paiement='" + getPaiement() + "'" +
            "}";
    }
}
