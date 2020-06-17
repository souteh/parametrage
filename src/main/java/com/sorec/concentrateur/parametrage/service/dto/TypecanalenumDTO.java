package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Typecanalenum} entity.
 */
public class TypecanalenumDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String terminal;

    @Size(max = 254)
    private String online;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypecanalenumDTO)) {
            return false;
        }

        return id != null && id.equals(((TypecanalenumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TypecanalenumDTO{" +
            "id=" + getId() +
            ", terminal='" + getTerminal() + "'" +
            ", online='" + getOnline() + "'" +
            "}";
    }
}
