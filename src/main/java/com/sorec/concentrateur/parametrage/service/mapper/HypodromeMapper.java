package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.HypodromeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Hypodrome} and its DTO {@link HypodromeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface HypodromeMapper extends EntityMapper<HypodromeDTO, Hypodrome> {



    default Hypodrome fromId(Long id) {
        if (id == null) {
            return null;
        }
        Hypodrome hypodrome = new Hypodrome();
        hypodrome.setId(id);
        return hypodrome;
    }
}
