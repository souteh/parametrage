package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Actionparam;
import com.sorec.concentrateur.parametrage.repository.ActionparamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Actionparam}.
 */
@Service
@Transactional
public class ActionparamService {

    private final Logger log = LoggerFactory.getLogger(ActionparamService.class);

    private final ActionparamRepository actionparamRepository;

    public ActionparamService(ActionparamRepository actionparamRepository) {
        this.actionparamRepository = actionparamRepository;
    }

    /**
     * Save a actionparam.
     *
     * @param actionparam the entity to save.
     * @return the persisted entity.
     */
    public Actionparam save(Actionparam actionparam) {
        log.debug("Request to save Actionparam : {}", actionparam);
        return actionparamRepository.save(actionparam);
    }

    /**
     * Get all the actionparams.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Actionparam> findAll(Pageable pageable) {
        log.debug("Request to get all Actionparams");
        return actionparamRepository.findAll(pageable);
    }


    /**
     * Get one actionparam by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Actionparam> findOne(Long id) {
        log.debug("Request to get Actionparam : {}", id);
        return actionparamRepository.findById(id);
    }

    /**
     * Delete the actionparam by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Actionparam : {}", id);
        actionparamRepository.deleteById(id);
    }
}
