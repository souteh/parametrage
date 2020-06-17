package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Typepaiementenum} entity.
 */
public class TypepaiementenumDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String total;

    @Size(max = 254)
    private String avance;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypepaiementenumDTO)) {
            return false;
        }

        return id != null && id.equals(((TypepaiementenumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TypepaiementenumDTO{" +
            "id=" + getId() +
            ", total='" + getTotal() + "'" +
            ", avance='" + getAvance() + "'" +
            "}";
    }
}
