package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.Association12DTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Association12} and its DTO {@link Association12DTO}.
 */
@Mapper(componentModel = "spring", uses = {ClientglentityMapper.class})
public interface Association12Mapper extends EntityMapper<Association12DTO, Association12> {

    @Mapping(source = "id.id", target = "idId")
    Association12DTO toDto(Association12 association12);

    @Mapping(source = "idId", target = "id")
    Association12 toEntity(Association12DTO association12DTO);

    default Association12 fromId(Long id) {
        if (id == null) {
            return null;
        }
        Association12 association12 = new Association12();
        association12.setId(id);
        return association12;
    }
}
