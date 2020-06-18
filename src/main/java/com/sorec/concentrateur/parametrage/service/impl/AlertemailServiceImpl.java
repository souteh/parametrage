package com.sorec.concentrateur.parametrage.service.impl;

import com.sorec.concentrateur.parametrage.service.AlertemailService;
import com.sorec.concentrateur.parametrage.domain.Alertemail;
import com.sorec.concentrateur.parametrage.repository.AlertemailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Alertemail}.
 */
@Service
@Transactional
public class AlertemailServiceImpl implements AlertemailService {

    private final Logger log = LoggerFactory.getLogger(AlertemailServiceImpl.class);

    private final AlertemailRepository alertemailRepository;

    public AlertemailServiceImpl(AlertemailRepository alertemailRepository) {
        this.alertemailRepository = alertemailRepository;
    }

    /**
     * Save a alertemail.
     *
     * @param alertemail the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Alertemail save(Alertemail alertemail) {
        log.debug("Request to save Alertemail : {}", alertemail);
        return alertemailRepository.save(alertemail);
    }

    /**
     * Get all the alertemails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Alertemail> findAll(Pageable pageable) {
        log.debug("Request to get all Alertemails");
        return alertemailRepository.findAll(pageable);
    }


    /**
     * Get one alertemail by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Alertemail> findOne(Long id) {
        log.debug("Request to get Alertemail : {}", id);
        return alertemailRepository.findById(id);
    }

    /**
     * Delete the alertemail by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Alertemail : {}", id);
        alertemailRepository.deleteById(id);
    }
}
