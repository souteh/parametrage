package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.Smtp} entity.
 */
public class SmtpDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer idsmtp;

    @Size(max = 254)
    private String codesmtp;

    @Size(max = 254)
    private String adresseipsmtp;

    @Size(max = 254)
    private String authentification;

    @Size(max = 254)
    private String statut;

    @Size(max = 254)
    private String login;

    @Size(max = 254)
    private String password;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdsmtp() {
        return idsmtp;
    }

    public void setIdsmtp(Integer idsmtp) {
        this.idsmtp = idsmtp;
    }

    public String getCodesmtp() {
        return codesmtp;
    }

    public void setCodesmtp(String codesmtp) {
        this.codesmtp = codesmtp;
    }

    public String getAdresseipsmtp() {
        return adresseipsmtp;
    }

    public void setAdresseipsmtp(String adresseipsmtp) {
        this.adresseipsmtp = adresseipsmtp;
    }

    public String getAuthentification() {
        return authentification;
    }

    public void setAuthentification(String authentification) {
        this.authentification = authentification;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SmtpDTO)) {
            return false;
        }

        return id != null && id.equals(((SmtpDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SmtpDTO{" +
            "id=" + getId() +
            ", idsmtp=" + getIdsmtp() +
            ", codesmtp='" + getCodesmtp() + "'" +
            ", adresseipsmtp='" + getAdresseipsmtp() + "'" +
            ", authentification='" + getAuthentification() + "'" +
            ", statut='" + getStatut() + "'" +
            ", login='" + getLogin() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
