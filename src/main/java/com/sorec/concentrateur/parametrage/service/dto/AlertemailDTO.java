package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Alertemail} entity.
 */
public class AlertemailDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idalertemail;

    @Size(max = 254)
    private String codealertemail;

    @Size(max = 254)
    private String typealertemail;

    @Size(max = 254)
    private String objetalertemail;

    @Size(max = 254)
    private String adressemaildiffusion;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdalertemail() {
        return idalertemail;
    }

    public void setIdalertemail(Integer idalertemail) {
        this.idalertemail = idalertemail;
    }

    public String getCodealertemail() {
        return codealertemail;
    }

    public void setCodealertemail(String codealertemail) {
        this.codealertemail = codealertemail;
    }

    public String getTypealertemail() {
        return typealertemail;
    }

    public void setTypealertemail(String typealertemail) {
        this.typealertemail = typealertemail;
    }

    public String getObjetalertemail() {
        return objetalertemail;
    }

    public void setObjetalertemail(String objetalertemail) {
        this.objetalertemail = objetalertemail;
    }

    public String getAdressemaildiffusion() {
        return adressemaildiffusion;
    }

    public void setAdressemaildiffusion(String adressemaildiffusion) {
        this.adressemaildiffusion = adressemaildiffusion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlertemailDTO)) {
            return false;
        }

        return id != null && id.equals(((AlertemailDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AlertemailDTO{" +
            "id=" + getId() +
            ", idalertemail=" + getIdalertemail() +
            ", codealertemail='" + getCodealertemail() + "'" +
            ", typealertemail='" + getTypealertemail() + "'" +
            ", objetalertemail='" + getObjetalertemail() + "'" +
            ", adressemaildiffusion='" + getAdressemaildiffusion() + "'" +
            "}";
    }
}
