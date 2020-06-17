package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.I18nTextTranslationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link I18nTextTranslation} and its DTO {@link I18nTextTranslationDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface I18nTextTranslationMapper extends EntityMapper<I18nTextTranslationDTO, I18nTextTranslation> {



    default I18nTextTranslation fromId(Long id) {
        if (id == null) {
            return null;
        }
        I18nTextTranslation i18nTextTranslation = new I18nTextTranslation();
        i18nTextTranslation.setId(id);
        return i18nTextTranslation;
    }
}
