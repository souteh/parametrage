package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.ChoisitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Choisit} and its DTO {@link ChoisitDTO}.
 */
@Mapper(componentModel = "spring", uses = {AttributaireMapper.class})
public interface ChoisitMapper extends EntityMapper<ChoisitDTO, Choisit> {

    @Mapping(source = "idattributaire.id", target = "idattributaireId")
    ChoisitDTO toDto(Choisit choisit);

    @Mapping(source = "idattributaireId", target = "idattributaire")
    Choisit toEntity(ChoisitDTO choisitDTO);

    default Choisit fromId(Long id) {
        if (id == null) {
            return null;
        }
        Choisit choisit = new Choisit();
        choisit.setId(id);
        return choisit;
    }
}
