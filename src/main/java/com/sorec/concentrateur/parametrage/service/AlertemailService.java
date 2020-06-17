package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Alertemail;
import com.sorec.concentrateur.parametrage.repository.AlertemailRepository;
import com.sorec.concentrateur.parametrage.service.dto.AlertemailDTO;
import com.sorec.concentrateur.parametrage.service.mapper.AlertemailMapper;
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
public class AlertemailService {

    private final Logger log = LoggerFactory.getLogger(AlertemailService.class);

    private final AlertemailRepository alertemailRepository;

    private final AlertemailMapper alertemailMapper;

    public AlertemailService(AlertemailRepository alertemailRepository, AlertemailMapper alertemailMapper) {
        this.alertemailRepository = alertemailRepository;
        this.alertemailMapper = alertemailMapper;
    }

    /**
     * Save a alertemail.
     *
     * @param alertemailDTO the entity to save.
     * @return the persisted entity.
     */
    public AlertemailDTO save(AlertemailDTO alertemailDTO) {
        log.debug("Request to save Alertemail : {}", alertemailDTO);
        Alertemail alertemail = alertemailMapper.toEntity(alertemailDTO);
        alertemail = alertemailRepository.save(alertemail);
        return alertemailMapper.toDto(alertemail);
    }

    /**
     * Get all the alertemails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AlertemailDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Alertemails");
        return alertemailRepository.findAll(pageable)
            .map(alertemailMapper::toDto);
    }


    /**
     * Get one alertemail by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AlertemailDTO> findOne(Long id) {
        log.debug("Request to get Alertemail : {}", id);
        return alertemailRepository.findById(id)
            .map(alertemailMapper::toDto);
    }

    /**
     * Delete the alertemail by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Alertemail : {}", id);
        alertemailRepository.deleteById(id);
    }
}
