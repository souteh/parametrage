package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Produit} entity.
 */
public class ProduitDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idproduit;

    @Size(max = 254)
    private String designation;

    @Size(max = 254)
    private String libelle;

    @Size(max = 254)
    private String codeproduit;

    private Integer enjeumin;

    @Size(max = 254)
    private String ordre;

    private Integer nbrechevauxbase;

    private Integer nbreminpartant;

    private Integer champx;

    private Integer express;

    @Size(max = 254)
    private String appartenance;

    private Integer enjeumax;

    @Size(max = 254)
    private String statut;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeproduit() {
        return codeproduit;
    }

    public void setCodeproduit(String codeproduit) {
        this.codeproduit = codeproduit;
    }

    public Integer getEnjeumin() {
        return enjeumin;
    }

    public void setEnjeumin(Integer enjeumin) {
        this.enjeumin = enjeumin;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public Integer getNbrechevauxbase() {
        return nbrechevauxbase;
    }

    public void setNbrechevauxbase(Integer nbrechevauxbase) {
        this.nbrechevauxbase = nbrechevauxbase;
    }

    public Integer getNbreminpartant() {
        return nbreminpartant;
    }

    public void setNbreminpartant(Integer nbreminpartant) {
        this.nbreminpartant = nbreminpartant;
    }

    public Integer getChampx() {
        return champx;
    }

    public void setChampx(Integer champx) {
        this.champx = champx;
    }

    public Integer getExpress() {
        return express;
    }

    public void setExpress(Integer express) {
        this.express = express;
    }

    public String getAppartenance() {
        return appartenance;
    }

    public void setAppartenance(String appartenance) {
        this.appartenance = appartenance;
    }

    public Integer getEnjeumax() {
        return enjeumax;
    }

    public void setEnjeumax(Integer enjeumax) {
        this.enjeumax = enjeumax;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProduitDTO)) {
            return false;
        }

        return id != null && id.equals(((ProduitDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProduitDTO{" +
            "id=" + getId() +
            ", idproduit=" + getIdproduit() +
            ", designation='" + getDesignation() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", codeproduit='" + getCodeproduit() + "'" +
            ", enjeumin=" + getEnjeumin() +
            ", ordre='" + getOrdre() + "'" +
            ", nbrechevauxbase=" + getNbrechevauxbase() +
            ", nbreminpartant=" + getNbreminpartant() +
            ", champx=" + getChampx() +
            ", express=" + getExpress() +
            ", appartenance='" + getAppartenance() + "'" +
            ", enjeumax=" + getEnjeumax() +
            ", statut='" + getStatut() + "'" +
            "}";
    }
}
