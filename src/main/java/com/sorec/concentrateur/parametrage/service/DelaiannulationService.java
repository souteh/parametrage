package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Delaiannulation;
import com.sorec.concentrateur.parametrage.repository.DelaiannulationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Delaiannulation}.
 */
@Service
@Transactional
public class DelaiannulationService {

    private final Logger log = LoggerFactory.getLogger(DelaiannulationService.class);

    private final DelaiannulationRepository delaiannulationRepository;

    public DelaiannulationService(DelaiannulationRepository delaiannulationRepository) {
        this.delaiannulationRepository = delaiannulationRepository;
    }

    /**
     * Save a delaiannulation.
     *
     * @param delaiannulation the entity to save.
     * @return the persisted entity.
     */
    public Delaiannulation save(Delaiannulation delaiannulation) {
        log.debug("Request to save Delaiannulation : {}", delaiannulation);
        return delaiannulationRepository.save(delaiannulation);
    }

    /**
     * Get all the delaiannulations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Delaiannulation> findAll(Pageable pageable) {
        log.debug("Request to get all Delaiannulations");
        return delaiannulationRepository.findAll(pageable);
    }


    /**
     * Get one delaiannulation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Delaiannulation> findOne(Long id) {
        log.debug("Request to get Delaiannulation : {}", id);
        return delaiannulationRepository.findById(id);
    }

    /**
     * Delete the delaiannulation by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Delaiannulation : {}", id);
        delaiannulationRepository.deleteById(id);
    }
}