package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Clientglentity} entity.
 */
public class ClientglentityDTO implements Serializable {
    
    private Long id;

    @Size(max = 254)
    private String nom;

    @Size(max = 254)
    private String prenom;

    @Size(max = 254)
    private String cin;

    @Size(max = 254)
    private String telephone;

    @Size(max = 254)
    private String commentaire;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClientglentityDTO)) {
            return false;
        }

        return id != null && id.equals(((ClientglentityDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClientglentityDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", cin='" + getCin() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", commentaire='" + getCommentaire() + "'" +
            "}";
    }
}
