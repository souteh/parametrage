package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typeterminalenum;
import com.sorec.concentrateur.parametrage.repository.TypeterminalenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypeterminalenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypeterminalenumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typeterminalenum}.
 */
@Service
@Transactional
public class TypeterminalenumService {

    private final Logger log = LoggerFactory.getLogger(TypeterminalenumService.class);

    private final TypeterminalenumRepository typeterminalenumRepository;

    private final TypeterminalenumMapper typeterminalenumMapper;

    public TypeterminalenumService(TypeterminalenumRepository typeterminalenumRepository, TypeterminalenumMapper typeterminalenumMapper) {
        this.typeterminalenumRepository = typeterminalenumRepository;
        this.typeterminalenumMapper = typeterminalenumMapper;
    }

    /**
     * Save a typeterminalenum.
     *
     * @param typeterminalenumDTO the entity to save.
     * @return the persisted entity.
     */
    public TypeterminalenumDTO save(TypeterminalenumDTO typeterminalenumDTO) {
        log.debug("Request to save Typeterminalenum : {}", typeterminalenumDTO);
        Typeterminalenum typeterminalenum = typeterminalenumMapper.toEntity(typeterminalenumDTO);
        typeterminalenum = typeterminalenumRepository.save(typeterminalenum);
        return typeterminalenumMapper.toDto(typeterminalenum);
    }

    /**
     * Get all the typeterminalenums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TypeterminalenumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Typeterminalenums");
        return typeterminalenumRepository.findAll(pageable)
            .map(typeterminalenumMapper::toDto);
    }


    /**
     * Get one typeterminalenum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TypeterminalenumDTO> findOne(Long id) {
        log.debug("Request to get Typeterminalenum : {}", id);
        return typeterminalenumRepository.findById(id)
            .map(typeterminalenumMapper::toDto);
    }

    /**
     * Delete the typeterminalenum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typeterminalenum : {}", id);
        typeterminalenumRepository.deleteById(id);
    }
}
