package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Catonlinecanalenum} entity.
 */
public class CatonlinecanalenumDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String pel;

    @Size(max = 254)
    private String ptel;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPel() {
        return pel;
    }

    public void setPel(String pel) {
        this.pel = pel;
    }

    public String getPtel() {
        return ptel;
    }

    public void setPtel(String ptel) {
        this.ptel = ptel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CatonlinecanalenumDTO)) {
            return false;
        }

        return id != null && id.equals(((CatonlinecanalenumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CatonlinecanalenumDTO{" +
            "id=" + getId() +
            ", pel='" + getPel() + "'" +
            ", ptel='" + getPtel() + "'" +
            "}";
    }
}
