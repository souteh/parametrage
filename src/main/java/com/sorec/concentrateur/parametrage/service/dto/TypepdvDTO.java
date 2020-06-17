package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Typepdv} entity.
 */
public class TypepdvDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idtypepdv;

    @Size(max = 254)
    private String reftypepdv;

    @Size(max = 254)
    private String type;

    private Integer nbremaxterminaux;

    private Integer plafondpostpaye;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdtypepdv() {
        return idtypepdv;
    }

    public void setIdtypepdv(Integer idtypepdv) {
        this.idtypepdv = idtypepdv;
    }

    public String getReftypepdv() {
        return reftypepdv;
    }

    public void setReftypepdv(String reftypepdv) {
        this.reftypepdv = reftypepdv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNbremaxterminaux() {
        return nbremaxterminaux;
    }

    public void setNbremaxterminaux(Integer nbremaxterminaux) {
        this.nbremaxterminaux = nbremaxterminaux;
    }

    public Integer getPlafondpostpaye() {
        return plafondpostpaye;
    }

    public void setPlafondpostpaye(Integer plafondpostpaye) {
        this.plafondpostpaye = plafondpostpaye;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypepdvDTO)) {
            return false;
        }

        return id != null && id.equals(((TypepdvDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TypepdvDTO{" +
            "id=" + getId() +
            ", idtypepdv=" + getIdtypepdv() +
            ", reftypepdv='" + getReftypepdv() + "'" +
            ", type='" + getType() + "'" +
            ", nbremaxterminaux=" + getNbremaxterminaux() +
            ", plafondpostpaye=" + getPlafondpostpaye() +
            "}";
    }
}
