package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Typeterminalenum} entity.
 */
public class TypeterminalenumDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String t2020;

    @Size(max = 254)
    private String t2030;

    @Size(max = 254)
    private String b2062;

    @Size(max = 254)
    private String pda;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gett2020() {
        return t2020;
    }

    public void sett2020(String t2020) {
        this.t2020 = t2020;
    }

    public String gett2030() {
        return t2030;
    }

    public void sett2030(String t2030) {
        this.t2030 = t2030;
    }

    public String getb2062() {
        return b2062;
    }

    public void setb2062(String b2062) {
        this.b2062 = b2062;
    }

    public String getPda() {
        return pda;
    }

    public void setPda(String pda) {
        this.pda = pda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypeterminalenumDTO)) {
            return false;
        }

        return id != null && id.equals(((TypeterminalenumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TypeterminalenumDTO{" +
            "id=" + getId() +
            ", t2020='" + gett2020() + "'" +
            ", t2030='" + gett2030() + "'" +
            ", b2062='" + getb2062() + "'" +
            ", pda='" + getPda() + "'" +
            "}";
    }
}
