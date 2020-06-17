package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.AlertemailDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Alertemail} and its DTO {@link AlertemailDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AlertemailMapper extends EntityMapper<AlertemailDTO, Alertemail> {



    default Alertemail fromId(Long id) {
        if (id == null) {
            return null;
        }
        Alertemail alertemail = new Alertemail();
        alertemail.setId(id);
        return alertemail;
    }
}
