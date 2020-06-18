package com.sorec.concentrateur.parametrage.service.impl;

import com.sorec.concentrateur.parametrage.service.PdvService;
import com.sorec.concentrateur.parametrage.domain.Pdv;
import com.sorec.concentrateur.parametrage.repository.PdvRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Pdv}.
 */
@Service
@Transactional
public class PdvServiceImpl implements PdvService {

    private final Logger log = LoggerFactory.getLogger(PdvServiceImpl.class);

    private final PdvRepository pdvRepository;

    public PdvServiceImpl(PdvRepository pdvRepository) {
        this.pdvRepository = pdvRepository;
    }

    /**
     * Save a pdv.
     *
     * @param pdv the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Pdv save(Pdv pdv) {
        log.debug("Request to save Pdv : {}", pdv);
        return pdvRepository.save(pdv);
    }

    /**
     * Get all the pdvs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Pdv> findAll(Pageable pageable) {
        log.debug("Request to get all Pdvs");
        return pdvRepository.findAll(pageable);
    }


    /**
     * Get one pdv by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Pdv> findOne(Long id) {
        log.debug("Request to get Pdv : {}", id);
        return pdvRepository.findById(id);
    }

    /**
     * Delete the pdv by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Pdv : {}", id);
        pdvRepository.deleteById(id);
    }
}
