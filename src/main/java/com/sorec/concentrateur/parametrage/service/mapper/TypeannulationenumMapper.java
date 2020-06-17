package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.TypeannulationenumDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Typeannulationenum} and its DTO {@link TypeannulationenumDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TypeannulationenumMapper extends EntityMapper<TypeannulationenumDTO, Typeannulationenum> {



    default Typeannulationenum fromId(Long id) {
        if (id == null) {
            return null;
        }
        Typeannulationenum typeannulationenum = new Typeannulationenum();
        typeannulationenum.setId(id);
        return typeannulationenum;
    }
}
