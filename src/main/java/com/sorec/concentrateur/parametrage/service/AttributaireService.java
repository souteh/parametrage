package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Attributaire;
import com.sorec.concentrateur.parametrage.repository.AttributaireRepository;
import com.sorec.concentrateur.parametrage.service.dto.AttributaireDTO;
import com.sorec.concentrateur.parametrage.service.mapper.AttributaireMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Attributaire}.
 */
@Service
@Transactional
public class AttributaireService {

    private final Logger log = LoggerFactory.getLogger(AttributaireService.class);

    private final AttributaireRepository attributaireRepository;

    private final AttributaireMapper attributaireMapper;

    public AttributaireService(AttributaireRepository attributaireRepository, AttributaireMapper attributaireMapper) {
        this.attributaireRepository = attributaireRepository;
        this.attributaireMapper = attributaireMapper;
    }

    /**
     * Save a attributaire.
     *
     * @param attributaireDTO the entity to save.
     * @return the persisted entity.
     */
    public AttributaireDTO save(AttributaireDTO attributaireDTO) {
        log.debug("Request to save Attributaire : {}", attributaireDTO);
        Attributaire attributaire = attributaireMapper.toEntity(attributaireDTO);
        attributaire = attributaireRepository.save(attributaire);
        return attributaireMapper.toDto(attributaire);
    }

    /**
     * Get all the attributaires.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AttributaireDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Attributaires");
        return attributaireRepository.findAll(pageable)
            .map(attributaireMapper::toDto);
    }


    /**
     * Get one attributaire by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AttributaireDTO> findOne(Long id) {
        log.debug("Request to get Attributaire : {}", id);
        return attributaireRepository.findById(id)
            .map(attributaireMapper::toDto);
    }

    /**
     * Delete the attributaire by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Attributaire : {}", id);
        attributaireRepository.deleteById(id);
    }
}
