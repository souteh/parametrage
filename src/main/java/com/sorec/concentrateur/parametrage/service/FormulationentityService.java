package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Formulationentity;
import com.sorec.concentrateur.parametrage.repository.FormulationentityRepository;
import com.sorec.concentrateur.parametrage.service.dto.FormulationentityDTO;
import com.sorec.concentrateur.parametrage.service.mapper.FormulationentityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Formulationentity}.
 */
@Service
@Transactional
public class FormulationentityService {

    private final Logger log = LoggerFactory.getLogger(FormulationentityService.class);

    private final FormulationentityRepository formulationentityRepository;

    private final FormulationentityMapper formulationentityMapper;

    public FormulationentityService(FormulationentityRepository formulationentityRepository, FormulationentityMapper formulationentityMapper) {
        this.formulationentityRepository = formulationentityRepository;
        this.formulationentityMapper = formulationentityMapper;
    }

    /**
     * Save a formulationentity.
     *
     * @param formulationentityDTO the entity to save.
     * @return the persisted entity.
     */
    public FormulationentityDTO save(FormulationentityDTO formulationentityDTO) {
        log.debug("Request to save Formulationentity : {}", formulationentityDTO);
        Formulationentity formulationentity = formulationentityMapper.toEntity(formulationentityDTO);
        formulationentity = formulationentityRepository.save(formulationentity);
        return formulationentityMapper.toDto(formulationentity);
    }

    /**
     * Get all the formulationentities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<FormulationentityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Formulationentities");
        return formulationentityRepository.findAll(pageable)
            .map(formulationentityMapper::toDto);
    }


    /**
     * Get one formulationentity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FormulationentityDTO> findOne(Long id) {
        log.debug("Request to get Formulationentity : {}", id);
        return formulationentityRepository.findById(id)
            .map(formulationentityMapper::toDto);
    }

    /**
     * Delete the formulationentity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Formulationentity : {}", id);
        formulationentityRepository.deleteById(id);
    }
}
