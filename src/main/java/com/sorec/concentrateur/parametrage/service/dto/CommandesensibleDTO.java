package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Commandesensible} entity.
 */
public class CommandesensibleDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idcommandesensible;

    @Size(max = 254)
    private String codecommandesensible;

    @Size(max = 254)
    private String libellecommandesensible;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdcommandesensible() {
        return idcommandesensible;
    }

    public void setIdcommandesensible(Integer idcommandesensible) {
        this.idcommandesensible = idcommandesensible;
    }

    public String getCodecommandesensible() {
        return codecommandesensible;
    }

    public void setCodecommandesensible(String codecommandesensible) {
        this.codecommandesensible = codecommandesensible;
    }

    public String getLibellecommandesensible() {
        return libellecommandesensible;
    }

    public void setLibellecommandesensible(String libellecommandesensible) {
        this.libellecommandesensible = libellecommandesensible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommandesensibleDTO)) {
            return false;
        }

        return id != null && id.equals(((CommandesensibleDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CommandesensibleDTO{" +
            "id=" + getId() +
            ", idcommandesensible=" + getIdcommandesensible() +
            ", codecommandesensible='" + getCodecommandesensible() + "'" +
            ", libellecommandesensible='" + getLibellecommandesensible() + "'" +
            "}";
    }
}
