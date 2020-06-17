package com.sorec.concentrateur.parametrage.service.mapper;


import com.sorec.concentrateur.parametrage.domain.*;
import com.sorec.concentrateur.parametrage.service.dto.TypepdvDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Typepdv} and its DTO {@link TypepdvDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TypepdvMapper extends EntityMapper<TypepdvDTO, Typepdv> {



    default Typepdv fromId(Long id) {
        if (id == null) {
            return null;
        }
        Typepdv typepdv = new Typepdv();
        typepdv.setId(id);
        return typepdv;
    }
}
