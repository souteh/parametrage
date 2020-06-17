package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Choisit;
import com.sorec.concentrateur.parametrage.repository.ChoisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Choisit}.
 */
@Service
@Transactional
public class ChoisitService {

    private final Logger log = LoggerFactory.getLogger(ChoisitService.class);

    private final ChoisitRepository choisitRepository;

    public ChoisitService(ChoisitRepository choisitRepository) {
        this.choisitRepository = choisitRepository;
    }

    /**
     * Save a choisit.
     *
     * @param choisit the entity to save.
     * @return the persisted entity.
     */
    public Choisit save(Choisit choisit) {
        log.debug("Request to save Choisit : {}", choisit);
        return choisitRepository.save(choisit);
    }

    /**
     * Get all the choisits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Choisit> findAll(Pageable pageable) {
        log.debug("Request to get all Choisits");
        return choisitRepository.findAll(pageable);
    }


    /**
     * Get one choisit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Choisit> findOne(Long id) {
        log.debug("Request to get Choisit : {}", id);
        return choisitRepository.findById(id);
    }

    /**
     * Delete the choisit by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Choisit : {}", id);
        choisitRepository.deleteById(id);
    }
}