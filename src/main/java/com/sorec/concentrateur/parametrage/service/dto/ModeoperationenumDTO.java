package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Modeoperationenum} entity.
 */
public class ModeoperationenumDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String automatique;

    @Size(max = 254)
    private String manuel;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutomatique() {
        return automatique;
    }

    public void setAutomatique(String automatique) {
        this.automatique = automatique;
    }

    public String getManuel() {
        return manuel;
    }

    public void setManuel(String manuel) {
        this.manuel = manuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModeoperationenumDTO)) {
            return false;
        }

        return id != null && id.equals(((ModeoperationenumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ModeoperationenumDTO{" +
            "id=" + getId() +
            ", automatique='" + getAutomatique() + "'" +
            ", manuel='" + getManuel() + "'" +
            "}";
    }
}
