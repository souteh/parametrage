package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Delaiannulation} entity.
 */
public class DelaiannulationDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer iddelaiannulation;

    @Size(max = 254)
    private String codedelaiannulation;

    @Size(max = 254)
    private String designationdelaiannulation;

    private Integer valeurdelaiannulation;

    @Size(max = 254)
    private String statut;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIddelaiannulation() {
        return iddelaiannulation;
    }

    public void setIddelaiannulation(Integer iddelaiannulation) {
        this.iddelaiannulation = iddelaiannulation;
    }

    public String getCodedelaiannulation() {
        return codedelaiannulation;
    }

    public void setCodedelaiannulation(String codedelaiannulation) {
        this.codedelaiannulation = codedelaiannulation;
    }

    public String getDesignationdelaiannulation() {
        return designationdelaiannulation;
    }

    public void setDesignationdelaiannulation(String designationdelaiannulation) {
        this.designationdelaiannulation = designationdelaiannulation;
    }

    public Integer getValeurdelaiannulation() {
        return valeurdelaiannulation;
    }

    public void setValeurdelaiannulation(Integer valeurdelaiannulation) {
        this.valeurdelaiannulation = valeurdelaiannulation;
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
        if (!(o instanceof DelaiannulationDTO)) {
            return false;
        }

        return id != null && id.equals(((DelaiannulationDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DelaiannulationDTO{" +
            "id=" + getId() +
            ", iddelaiannulation=" + getIddelaiannulation() +
            ", codedelaiannulation='" + getCodedelaiannulation() + "'" +
            ", designationdelaiannulation='" + getDesignationdelaiannulation() + "'" +
            ", valeurdelaiannulation=" + getValeurdelaiannulation() +
            ", statut='" + getStatut() + "'" +
            "}";
    }
}
