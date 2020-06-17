package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.CommandesensibleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Commandesensible} and its DTO {@link CommandesensibleDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CommandesensibleMapper extends EntityMapper<CommandesensibleDTO, Commandesensible> {



    default Commandesensible fromId(Long id) {
        if (id == null) {
            return null;
        }
        Commandesensible commandesensible = new Commandesensible();
        commandesensible.setId(id);
        return commandesensible;
    }
}
