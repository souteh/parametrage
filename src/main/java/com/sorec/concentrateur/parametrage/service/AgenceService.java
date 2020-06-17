package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Agence;
import com.sorec.concentrateur.parametrage.repository.AgenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Agence}.
 */
@Service
@Transactional
public class AgenceService {

    private final Logger log = LoggerFactory.getLogger(AgenceService.class);

    private final AgenceRepository agenceRepository;

    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    /**
     * Save a agence.
     *
     * @param agence the entity to save.
     * @return the persisted entity.
     */
    public Agence save(Agence agence) {
        log.debug("Request to save Agence : {}", agence);
        return agenceRepository.save(agence);
    }

    /**
     * Get all the agences.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Agence> findAll(Pageable pageable) {
        log.debug("Request to get all Agences");
        return agenceRepository.findAll(pageable);
    }


    /**
     * Get one agence by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Agence> findOne(Long id) {
        log.debug("Request to get Agence : {}", id);
        return agenceRepository.findById(id);
    }

    /**
     * Delete the agence by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Agence : {}", id);
        agenceRepository.deleteById(id);
    }
}
