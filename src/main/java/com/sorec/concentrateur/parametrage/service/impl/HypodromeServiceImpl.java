package com.sorec.concentrateur.parametrage.service.impl;

import com.sorec.concentrateur.parametrage.service.HypodromeService;
import com.sorec.concentrateur.parametrage.domain.Hypodrome;
import com.sorec.concentrateur.parametrage.repository.HypodromeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Hypodrome}.
 */
@Service
@Transactional
public class HypodromeServiceImpl implements HypodromeService {

    private final Logger log = LoggerFactory.getLogger(HypodromeServiceImpl.class);

    private final HypodromeRepository hypodromeRepository;

    public HypodromeServiceImpl(HypodromeRepository hypodromeRepository) {
        this.hypodromeRepository = hypodromeRepository;
    }

    /**
     * Save a hypodrome.
     *
     * @param hypodrome the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Hypodrome save(Hypodrome hypodrome) {
        log.debug("Request to save Hypodrome : {}", hypodrome);
        return hypodromeRepository.save(hypodrome);
    }

    /**
     * Get all the hypodromes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Hypodrome> findAll(Pageable pageable) {
        log.debug("Request to get all Hypodromes");
        return hypodromeRepository.findAll(pageable);
    }


    /**
     * Get one hypodrome by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Hypodrome> findOne(Long id) {
        log.debug("Request to get Hypodrome : {}", id);
        return hypodromeRepository.findById(id);
    }

    /**
     * Delete the hypodrome by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Hypodrome : {}", id);
        hypodromeRepository.deleteById(id);
    }
}
