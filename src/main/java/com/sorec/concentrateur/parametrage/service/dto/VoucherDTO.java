package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Voucher} entity.
 */
public class VoucherDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idvoucher;

    @Size(max = 254)
    private String codevoucher;

    @Size(max = 254)
    private String statut;

    @Size(max = 254)
    private String lieu;

    private Integer seuil;

    private Integer delaipurge;

    private Integer plafond;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdvoucher() {
        return idvoucher;
    }

    public void setIdvoucher(Integer idvoucher) {
        this.idvoucher = idvoucher;
    }

    public String getCodevoucher() {
        return codevoucher;
    }

    public void setCodevoucher(String codevoucher) {
        this.codevoucher = codevoucher;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Integer getSeuil() {
        return seuil;
    }

    public void setSeuil(Integer seuil) {
        this.seuil = seuil;
    }

    public Integer getDelaipurge() {
        return delaipurge;
    }

    public void setDelaipurge(Integer delaipurge) {
        this.delaipurge = delaipurge;
    }

    public Integer getPlafond() {
        return plafond;
    }

    public void setPlafond(Integer plafond) {
        this.plafond = plafond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VoucherDTO)) {
            return false;
        }

        return id != null && id.equals(((VoucherDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VoucherDTO{" +
            "id=" + getId() +
            ", idvoucher=" + getIdvoucher() +
            ", codevoucher='" + getCodevoucher() + "'" +
            ", statut='" + getStatut() + "'" +
            ", lieu='" + getLieu() + "'" +
            ", seuil=" + getSeuil() +
            ", delaipurge=" + getDelaipurge() +
            ", plafond=" + getPlafond() +
            "}";
    }
}
