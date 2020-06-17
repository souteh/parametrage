package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Smtp;
import com.sorec.concentrateur.parametrage.repository.SmtpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Smtp}.
 */
@Service
@Transactional
public class SmtpService {

    private final Logger log = LoggerFactory.getLogger(SmtpService.class);

    private final SmtpRepository smtpRepository;

    public SmtpService(SmtpRepository smtpRepository) {
        this.smtpRepository = smtpRepository;
    }

    /**
     * Save a smtp.
     *
     * @param smtp the entity to save.
     * @return the persisted entity.
     */
    public Smtp save(Smtp smtp) {
        log.debug("Request to save Smtp : {}", smtp);
        return smtpRepository.save(smtp);
    }

    /**
     * Get all the smtps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Smtp> findAll(Pageable pageable) {
        log.debug("Request to get all Smtps");
        return smtpRepository.findAll(pageable);
    }


    /**
     * Get one smtp by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Smtp> findOne(Long id) {
        log.debug("Request to get Smtp : {}", id);
        return smtpRepository.findById(id);
    }

    /**
     * Delete the smtp by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Smtp : {}", id);
        smtpRepository.deleteById(id);
    }
}
