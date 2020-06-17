package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Ville} entity.
 */
public class VilleDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idville;

    private Integer designation;

    @Size(max = 254)
    private String codeville;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdville() {
        return idville;
    }

    public void setIdville(Integer idville) {
        this.idville = idville;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public String getCodeville() {
        return codeville;
    }

    public void setCodeville(String codeville) {
        this.codeville = codeville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VilleDTO)) {
            return false;
        }

        return id != null && id.equals(((VilleDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VilleDTO{" +
            "id=" + getId() +
            ", idville=" + getIdville() +
            ", designation=" + getDesignation() +
            ", codeville='" + getCodeville() + "'" +
            "}";
    }
}
