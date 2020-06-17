package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Typeannulationenum} entity.
 */
public class TypeannulationenumDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String client;

    @Size(max = 254)
    private String machine;

    @Size(max = 254)
    private String exceptionnelle;

    @Size(max = 254)
    private String systeme;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getExceptionnelle() {
        return exceptionnelle;
    }

    public void setExceptionnelle(String exceptionnelle) {
        this.exceptionnelle = exceptionnelle;
    }

    public String getSysteme() {
        return systeme;
    }

    public void setSysteme(String systeme) {
        this.systeme = systeme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypeannulationenumDTO)) {
            return false;
        }

        return id != null && id.equals(((TypeannulationenumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TypeannulationenumDTO{" +
            "id=" + getId() +
            ", client='" + getClient() + "'" +
            ", machine='" + getMachine() + "'" +
            ", exceptionnelle='" + getExceptionnelle() + "'" +
            ", systeme='" + getSysteme() + "'" +
            "}";
    }
}
