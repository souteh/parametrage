package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Etape;
import com.sorec.concentrateur.parametrage.repository.EtapeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Etape}.
 */
@Service
@Transactional
public class EtapeService {

    private final Logger log = LoggerFactory.getLogger(EtapeService.class);

    private final EtapeRepository etapeRepository;

    public EtapeService(EtapeRepository etapeRepository) {
        this.etapeRepository = etapeRepository;
    }

    /**
     * Save a etape.
     *
     * @param etape the entity to save.
     * @return the persisted entity.
     */
    public Etape save(Etape etape) {
        log.debug("Request to save Etape : {}", etape);
        return etapeRepository.save(etape);
    }

    /**
     * Get all the etapes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Etape> findAll(Pageable pageable) {
        log.debug("Request to get all Etapes");
        return etapeRepository.findAll(pageable);
    }


    /**
     * Get one etape by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Etape> findOne(Long id) {
        log.debug("Request to get Etape : {}", id);
        return etapeRepository.findById(id);
    }

    /**
     * Delete the etape by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Etape : {}", id);
        etapeRepository.deleteById(id);
    }
}
