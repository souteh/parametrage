package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Paiementlots;
import com.sorec.concentrateur.parametrage.repository.PaiementlotsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Paiementlots}.
 */
@Service
@Transactional
public class PaiementlotsService {

    private final Logger log = LoggerFactory.getLogger(PaiementlotsService.class);

    private final PaiementlotsRepository paiementlotsRepository;

    public PaiementlotsService(PaiementlotsRepository paiementlotsRepository) {
        this.paiementlotsRepository = paiementlotsRepository;
    }

    /**
     * Save a paiementlots.
     *
     * @param paiementlots the entity to save.
     * @return the persisted entity.
     */
    public Paiementlots save(Paiementlots paiementlots) {
        log.debug("Request to save Paiementlots : {}", paiementlots);
        return paiementlotsRepository.save(paiementlots);
    }

    /**
     * Get all the paiementlots.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Paiementlots> findAll(Pageable pageable) {
        log.debug("Request to get all Paiementlots");
        return paiementlotsRepository.findAll(pageable);
    }


    /**
     * Get one paiementlots by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Paiementlots> findOne(Long id) {
        log.debug("Request to get Paiementlots : {}", id);
        return paiementlotsRepository.findById(id);
    }

    /**
     * Delete the paiementlots by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Paiementlots : {}", id);
        paiementlotsRepository.deleteById(id);
    }
}
