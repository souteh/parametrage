package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.SmtpDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Smtp} and its DTO {@link SmtpDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SmtpMapper extends EntityMapper<SmtpDTO, Smtp> {



    default Smtp fromId(Long id) {
        if (id == null) {
            return null;
        }
        Smtp smtp = new Smtp();
        smtp.setId(id);
        return smtp;
    }
}
