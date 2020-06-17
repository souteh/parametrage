package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Tfj;
import com.sorec.concentrateur.parametrage.repository.TfjRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Tfj}.
 */
@Service
@Transactional
public class TfjService {

    private final Logger log = LoggerFactory.getLogger(TfjService.class);

    private final TfjRepository tfjRepository;

    public TfjService(TfjRepository tfjRepository) {
        this.tfjRepository = tfjRepository;
    }

    /**
     * Save a tfj.
     *
     * @param tfj the entity to save.
     * @return the persisted entity.
     */
    public Tfj save(Tfj tfj) {
        log.debug("Request to save Tfj : {}", tfj);
        return tfjRepository.save(tfj);
    }

    /**
     * Get all the tfjs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Tfj> findAll(Pageable pageable) {
        log.debug("Request to get all Tfjs");
        return tfjRepository.findAll(pageable);
    }


    /**
     * Get one tfj by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Tfj> findOne(Long id) {
        log.debug("Request to get Tfj : {}", id);
        return tfjRepository.findById(id);
    }

    /**
     * Delete the tfj by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Tfj : {}", id);
        tfjRepository.deleteById(id);
    }
}
