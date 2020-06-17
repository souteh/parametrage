package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typepdv;
import com.sorec.concentrateur.parametrage.repository.TypepdvRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypepdvDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypepdvMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typepdv}.
 */
@Service
@Transactional
public class TypepdvService {

    private final Logger log = LoggerFactory.getLogger(TypepdvService.class);

    private final TypepdvRepository typepdvRepository;

    private final TypepdvMapper typepdvMapper;

    public TypepdvService(TypepdvRepository typepdvRepository, TypepdvMapper typepdvMapper) {
        this.typepdvRepository = typepdvRepository;
        this.typepdvMapper = typepdvMapper;
    }

    /**
     * Save a typepdv.
     *
     * @param typepdvDTO the entity to save.
     * @return the persisted entity.
     */
    public TypepdvDTO save(TypepdvDTO typepdvDTO) {
        log.debug("Request to save Typepdv : {}", typepdvDTO);
        Typepdv typepdv = typepdvMapper.toEntity(typepdvDTO);
        typepdv = typepdvRepository.save(typepdv);
        return typepdvMapper.toDto(typepdv);
    }

    /**
     * Get all the typepdvs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TypepdvDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Typepdvs");
        return typepdvRepository.findAll(pageable)
            .map(typepdvMapper::toDto);
    }


    /**
     * Get one typepdv by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TypepdvDTO> findOne(Long id) {
        log.debug("Request to get Typepdv : {}", id);
        return typepdvRepository.findById(id)
            .map(typepdvMapper::toDto);
    }

    /**
     * Delete the typepdv by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typepdv : {}", id);
        typepdvRepository.deleteById(id);
    }
}
