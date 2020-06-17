package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typeannulationenum;
import com.sorec.concentrateur.parametrage.repository.TypeannulationenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypeannulationenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypeannulationenumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typeannulationenum}.
 */
@Service
@Transactional
public class TypeannulationenumService {

    private final Logger log = LoggerFactory.getLogger(TypeannulationenumService.class);

    private final TypeannulationenumRepository typeannulationenumRepository;

    private final TypeannulationenumMapper typeannulationenumMapper;

    public TypeannulationenumService(TypeannulationenumRepository typeannulationenumRepository, TypeannulationenumMapper typeannulationenumMapper) {
        this.typeannulationenumRepository = typeannulationenumRepository;
        this.typeannulationenumMapper = typeannulationenumMapper;
    }

    /**
     * Save a typeannulationenum.
     *
     * @param typeannulationenumDTO the entity to save.
     * @return the persisted entity.
     */
    public TypeannulationenumDTO save(TypeannulationenumDTO typeannulationenumDTO) {
        log.debug("Request to save Typeannulationenum : {}", typeannulationenumDTO);
        Typeannulationenum typeannulationenum = typeannulationenumMapper.toEntity(typeannulationenumDTO);
        typeannulationenum = typeannulationenumRepository.save(typeannulationenum);
        return typeannulationenumMapper.toDto(typeannulationenum);
    }

    /**
     * Get all the typeannulationenums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TypeannulationenumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Typeannulationenums");
        return typeannulationenumRepository.findAll(pageable)
            .map(typeannulationenumMapper::toDto);
    }


    /**
     * Get one typeannulationenum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TypeannulationenumDTO> findOne(Long id) {
        log.debug("Request to get Typeannulationenum : {}", id);
        return typeannulationenumRepository.findById(id)
            .map(typeannulationenumMapper::toDto);
    }

    /**
     * Delete the typeannulationenum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typeannulationenum : {}", id);
        typeannulationenumRepository.deleteById(id);
    }
}
