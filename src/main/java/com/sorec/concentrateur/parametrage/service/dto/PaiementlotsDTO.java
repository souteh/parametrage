package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Paiementlots} entity.
 */
public class PaiementlotsDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idlotpaiement;

    @Size(max = 254)
    private String codepaiement;

    @Size(max = 254)
    private String type;

    private Integer seuil;

    private Integer montantavance;

    private Integer delaipurge;

    @Size(max = 254)
    private String lieuautorise;

    @Size(max = 254)
    private String lieuannulation;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdlotpaiement() {
        return idlotpaiement;
    }

    public void setIdlotpaiement(Integer idlotpaiement) {
        this.idlotpaiement = idlotpaiement;
    }

    public String getCodepaiement() {
        return codepaiement;
    }

    public void setCodepaiement(String codepaiement) {
        this.codepaiement = codepaiement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSeuil() {
        return seuil;
    }

    public void setSeuil(Integer seuil) {
        this.seuil = seuil;
    }

    public Integer getMontantavance() {
        return montantavance;
    }

    public void setMontantavance(Integer montantavance) {
        this.montantavance = montantavance;
    }

    public Integer getDelaipurge() {
        return delaipurge;
    }

    public void setDelaipurge(Integer delaipurge) {
        this.delaipurge = delaipurge;
    }

    public String getLieuautorise() {
        return lieuautorise;
    }

    public void setLieuautorise(String lieuautorise) {
        this.lieuautorise = lieuautorise;
    }

    public String getLieuannulation() {
        return lieuannulation;
    }

    public void setLieuannulation(String lieuannulation) {
        this.lieuannulation = lieuannulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaiementlotsDTO)) {
            return false;
        }

        return id != null && id.equals(((PaiementlotsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaiementlotsDTO{" +
            "id=" + getId() +
            ", idlotpaiement=" + getIdlotpaiement() +
            ", codepaiement='" + getCodepaiement() + "'" +
            ", type='" + getType() + "'" +
            ", seuil=" + getSeuil() +
            ", montantavance=" + getMontantavance() +
            ", delaipurge=" + getDelaipurge() +
            ", lieuautorise='" + getLieuautorise() + "'" +
            ", lieuannulation='" + getLieuannulation() + "'" +
            "}";
    }
}
