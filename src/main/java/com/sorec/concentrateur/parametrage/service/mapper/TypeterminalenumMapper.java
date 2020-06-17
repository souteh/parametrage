package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.TypeterminalenumDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Typeterminalenum} and its DTO {@link TypeterminalenumDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TypeterminalenumMapper extends EntityMapper<TypeterminalenumDTO, Typeterminalenum> {



    default Typeterminalenum fromId(Long id) {
        if (id == null) {
            return null;
        }
        Typeterminalenum typeterminalenum = new Typeterminalenum();
        typeterminalenum.setId(id);
        return typeterminalenum;
    }
}
