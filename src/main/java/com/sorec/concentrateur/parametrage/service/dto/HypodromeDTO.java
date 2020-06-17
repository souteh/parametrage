package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Hypodrome} entity.
 */
public class HypodromeDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idhypodrome;

    private Integer codehypodrome;

    @Size(max = 254)
    private String abreviation;

    @Size(max = 254)
    private String pays;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdhypodrome() {
        return idhypodrome;
    }

    public void setIdhypodrome(Integer idhypodrome) {
        this.idhypodrome = idhypodrome;
    }

    public Integer getCodehypodrome() {
        return codehypodrome;
    }

    public void setCodehypodrome(Integer codehypodrome) {
        this.codehypodrome = codehypodrome;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HypodromeDTO)) {
            return false;
        }

        return id != null && id.equals(((HypodromeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HypodromeDTO{" +
            "id=" + getId() +
            ", idhypodrome=" + getIdhypodrome() +
            ", codehypodrome=" + getCodehypodrome() +
            ", abreviation='" + getAbreviation() + "'" +
            ", pays='" + getPays() + "'" +
            "}";
    }
}
