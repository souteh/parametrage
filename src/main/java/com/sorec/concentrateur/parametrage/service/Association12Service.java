package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Association12;
import com.sorec.concentrateur.parametrage.repository.Association12Repository;
import com.sorec.concentrateur.parametrage.service.dto.Association12DTO;
import com.sorec.concentrateur.parametrage.service.mapper.Association12Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Association12}.
 */
@Service
@Transactional
public class Association12Service {

    private final Logger log = LoggerFactory.getLogger(Association12Service.class);

    private final Association12Repository association12Repository;

    private final Association12Mapper association12Mapper;

    public Association12Service(Association12Repository association12Repository, Association12Mapper association12Mapper) {
        this.association12Repository = association12Repository;
        this.association12Mapper = association12Mapper;
    }

    /**
     * Save a association12.
     *
     * @param association12DTO the entity to save.
     * @return the persisted entity.
     */
    public Association12DTO save(Association12DTO association12DTO) {
        log.debug("Request to save Association12 : {}", association12DTO);
        Association12 association12 = association12Mapper.toEntity(association12DTO);
        association12 = association12Repository.save(association12);
        return association12Mapper.toDto(association12);
    }

    /**
     * Get all the association12s.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Association12DTO> findAll(Pageable pageable) {
        log.debug("Request to get all Association12s");
        return association12Repository.findAll(pageable)
            .map(association12Mapper::toDto);
    }


    /**
     * Get one association12 by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Association12DTO> findOne(Long id) {
        log.debug("Request to get Association12 : {}", id);
        return association12Repository.findById(id)
            .map(association12Mapper::toDto);
    }

    /**
     * Delete the association12 by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Association12 : {}", id);
        association12Repository.deleteById(id);
    }
}
