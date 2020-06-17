package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.ClientglentityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Clientglentity} and its DTO {@link ClientglentityDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ClientglentityMapper extends EntityMapper<ClientglentityDTO, Clientglentity> {



    default Clientglentity fromId(Long id) {
        if (id == null) {
            return null;
        }
        Clientglentity clientglentity = new Clientglentity();
        clientglentity.setId(id);
        return clientglentity;
    }
}
