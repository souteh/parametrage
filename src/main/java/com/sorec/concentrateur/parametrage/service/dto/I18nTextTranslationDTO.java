package com.sorec.concentrateur.parametrage.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.sorec.concentrateur.parametrage.domain.I18nTextTranslation} entity.
 */
public class I18nTextTranslationDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(max = 45)
    private String lang;

    @NotNull
    @Size(max = 512)
    private String translation;

    @NotNull
    private Integer i18nTextId;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Integer geti18nTextId() {
        return i18nTextId;
    }

    public void seti18nTextId(Integer i18nTextId) {
        this.i18nTextId = i18nTextId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof I18nTextTranslationDTO)) {
            return false;
        }

        return id != null && id.equals(((I18nTextTranslationDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "I18nTextTranslationDTO{" +
            "id=" + getId() +
            ", lang='" + getLang() + "'" +
            ", translation='" + getTranslation() + "'" +
            ", i18nTextId=" + geti18nTextId() +
            "}";
    }
}
