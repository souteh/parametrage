package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Formulationentity} entity.
 */
public class FormulationentityDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Long identifiantconc;

    private Long idformulation;

    @Size(max = 254)
    private String codeproduit;

    private Boolean formcomplete;

    @Size(max = 254)
    private String designation;

    @Size(max = 254)
    private String misecomb;

    private Integer misetotale;

    private Integer numform;

    
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

    public Long getIdformulation() {
        return idformulation;
    }

    public void setIdformulation(Long idformulation) {
        this.idformulation = idformulation;
    }

    public String getCodeproduit() {
        return codeproduit;
    }

    public void setCodeproduit(String codeproduit) {
        this.codeproduit = codeproduit;
    }

    public Boolean isFormcomplete() {
        return formcomplete;
    }

    public void setFormcomplete(Boolean formcomplete) {
        this.formcomplete = formcomplete;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMisecomb() {
        return misecomb;
    }

    public void setMisecomb(String misecomb) {
        this.misecomb = misecomb;
    }

    public Integer getMisetotale() {
        return misetotale;
    }

    public void setMisetotale(Integer misetotale) {
        this.misetotale = misetotale;
    }

    public Integer getNumform() {
        return numform;
    }

    public void setNumform(Integer numform) {
        this.numform = numform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FormulationentityDTO)) {
            return false;
        }

        return id != null && id.equals(((FormulationentityDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FormulationentityDTO{" +
            "id=" + getId() +
            ", identifiantconc=" + getIdentifiantconc() +
            ", idformulation=" + getIdformulation() +
            ", codeproduit='" + getCodeproduit() + "'" +
            ", formcomplete='" + isFormcomplete() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", misecomb='" + getMisecomb() + "'" +
            ", misetotale=" + getMisetotale() +
            ", numform=" + getNumform() +
            "}";
    }
}
