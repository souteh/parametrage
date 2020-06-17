package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.VersionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Version} and its DTO {@link VersionDTO}.
 */
@Mapper(componentModel = "spring", uses = {TypeterminalMapper.class})
public interface VersionMapper extends EntityMapper<VersionDTO, Version> {

    @Mapping(source = "idtypeterminal.id", target = "idtypeterminalId")
    VersionDTO toDto(Version version);

    @Mapping(source = "idtypeterminalId", target = "idtypeterminal")
    Version toEntity(VersionDTO versionDTO);

    default Version fromId(Long id) {
        if (id == null) {
            return null;
        }
        Version version = new Version();
        version.setId(id);
        return version;
    }
}
