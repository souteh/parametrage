package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.TypeterminalDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Typeterminal} and its DTO {@link TypeterminalDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TypeterminalMapper extends EntityMapper<TypeterminalDTO, Typeterminal> {



    default Typeterminal fromId(Long id) {
        if (id == null) {
            return null;
        }
        Typeterminal typeterminal = new Typeterminal();
        typeterminal.setId(id);
        return typeterminal;
    }
}
