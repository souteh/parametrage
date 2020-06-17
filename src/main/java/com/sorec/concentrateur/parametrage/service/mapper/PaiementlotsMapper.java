package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.PaiementlotsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Paiementlots} and its DTO {@link PaiementlotsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PaiementlotsMapper extends EntityMapper<PaiementlotsDTO, Paiementlots> {



    default Paiementlots fromId(Long id) {
        if (id == null) {
            return null;
        }
        Paiementlots paiementlots = new Paiementlots();
        paiementlots.setId(id);
        return paiementlots;
    }
}
