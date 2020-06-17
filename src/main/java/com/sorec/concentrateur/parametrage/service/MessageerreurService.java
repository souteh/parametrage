package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Messageerreur;
import com.sorec.concentrateur.parametrage.repository.MessageerreurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Messageerreur}.
 */
@Service
@Transactional
public class MessageerreurService {

    private final Logger log = LoggerFactory.getLogger(MessageerreurService.class);

    private final MessageerreurRepository messageerreurRepository;

    public MessageerreurService(MessageerreurRepository messageerreurRepository) {
        this.messageerreurRepository = messageerreurRepository;
    }

    /**
     * Save a messageerreur.
     *
     * @param messageerreur the entity to save.
     * @return the persisted entity.
     */
    public Messageerreur save(Messageerreur messageerreur) {
        log.debug("Request to save Messageerreur : {}", messageerreur);
        return messageerreurRepository.save(messageerreur);
    }

    /**
     * Get all the messageerreurs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Messageerreur> findAll(Pageable pageable) {
        log.debug("Request to get all Messageerreurs");
        return messageerreurRepository.findAll(pageable);
    }


    /**
     * Get one messageerreur by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Messageerreur> findOne(Long id) {
        log.debug("Request to get Messageerreur : {}", id);
        return messageerreurRepository.findById(id);
    }

    /**
     * Delete the messageerreur by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Messageerreur : {}", id);
        messageerreurRepository.deleteById(id);
    }
}
