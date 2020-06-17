package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.DelaiannulationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Delaiannulation} and its DTO {@link DelaiannulationDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DelaiannulationMapper extends EntityMapper<DelaiannulationDTO, Delaiannulation> {



    default Delaiannulation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Delaiannulation delaiannulation = new Delaiannulation();
        delaiannulation.setId(id);
        return delaiannulation;
    }
}
