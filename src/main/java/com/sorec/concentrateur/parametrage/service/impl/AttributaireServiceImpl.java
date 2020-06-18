package com.sorec.concentrateur.parametrage.service.impl;

import com.sorec.concentrateur.parametrage.service.AttributaireService;
import com.sorec.concentrateur.parametrage.domain.Attributaire;
import com.sorec.concentrateur.parametrage.repository.AttributaireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Attributaire}.
 */
@Service
@Transactional
public class AttributaireServiceImpl implements AttributaireService {

    private final Logger log = LoggerFactory.getLogger(AttributaireServiceImpl.class);

    private final AttributaireRepository attributaireRepository;

    public AttributaireServiceImpl(AttributaireRepository attributaireRepository) {
        this.attributaireRepository = attributaireRepository;
    }

    /**
     * Save a attributaire.
     *
     * @param attributaire the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Attributaire save(Attributaire attributaire) {
        log.debug("Request to save Attributaire : {}", attributaire);
        return attributaireRepository.save(attributaire);
    }

    /**
     * Get all the attributaires.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Attributaire> findAll(Pageable pageable) {
        log.debug("Request to get all Attributaires");
        return attributaireRepository.findAll(pageable);
    }


    /**
     * Get one attributaire by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Attributaire> findOne(Long id) {
        log.debug("Request to get Attributaire : {}", id);
        return attributaireRepository.findById(id);
    }

    /**
     * Delete the attributaire by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Attributaire : {}", id);
        attributaireRepository.deleteById(id);
    }
}
