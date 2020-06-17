package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.AttributaireDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Attributaire} and its DTO {@link AttributaireDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AttributaireMapper extends EntityMapper<AttributaireDTO, Attributaire> {



    default Attributaire fromId(Long id) {
        if (id == null) {
            return null;
        }
        Attributaire attributaire = new Attributaire();
        attributaire.setId(id);
        return attributaire;
    }
}
