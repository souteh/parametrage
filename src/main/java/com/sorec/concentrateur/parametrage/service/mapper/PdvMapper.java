package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.PdvDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Pdv} and its DTO {@link PdvDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PdvMapper extends EntityMapper<PdvDTO, Pdv> {



    default Pdv fromId(Long id) {
        if (id == null) {
            return null;
        }
        Pdv pdv = new Pdv();
        pdv.setId(id);
        return pdv;
    }
}
