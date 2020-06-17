package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typeterminal;
import com.sorec.concentrateur.parametrage.repository.TypeterminalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typeterminal}.
 */
@Service
@Transactional
public class TypeterminalService {

    private final Logger log = LoggerFactory.getLogger(TypeterminalService.class);

    private final TypeterminalRepository typeterminalRepository;

    public TypeterminalService(TypeterminalRepository typeterminalRepository) {
        this.typeterminalRepository = typeterminalRepository;
    }

    /**
     * Save a typeterminal.
     *
     * @param typeterminal the entity to save.
     * @return the persisted entity.
     */
    public Typeterminal save(Typeterminal typeterminal) {
        log.debug("Request to save Typeterminal : {}", typeterminal);
        return typeterminalRepository.save(typeterminal);
    }

    /**
     * Get all the typeterminals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Typeterminal> findAll(Pageable pageable) {
        log.debug("Request to get all Typeterminals");
        return typeterminalRepository.findAll(pageable);
    }


    /**
     * Get one typeterminal by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Typeterminal> findOne(Long id) {
        log.debug("Request to get Typeterminal : {}", id);
        return typeterminalRepository.findById(id);
    }

    /**
     * Delete the typeterminal by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typeterminal : {}", id);
        typeterminalRepository.deleteById(id);
    }
}
