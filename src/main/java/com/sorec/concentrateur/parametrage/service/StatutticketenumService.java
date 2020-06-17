package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Statutticketenum;
import com.sorec.concentrateur.parametrage.repository.StatutticketenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.StatutticketenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.StatutticketenumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Statutticketenum}.
 */
@Service
@Transactional
public class StatutticketenumService {

    private final Logger log = LoggerFactory.getLogger(StatutticketenumService.class);

    private final StatutticketenumRepository statutticketenumRepository;

    private final StatutticketenumMapper statutticketenumMapper;

    public StatutticketenumService(StatutticketenumRepository statutticketenumRepository, StatutticketenumMapper statutticketenumMapper) {
        this.statutticketenumRepository = statutticketenumRepository;
        this.statutticketenumMapper = statutticketenumMapper;
    }

    /**
     * Save a statutticketenum.
     *
     * @param statutticketenumDTO the entity to save.
     * @return the persisted entity.
     */
    public StatutticketenumDTO save(StatutticketenumDTO statutticketenumDTO) {
        log.debug("Request to save Statutticketenum : {}", statutticketenumDTO);
        Statutticketenum statutticketenum = statutticketenumMapper.toEntity(statutticketenumDTO);
        statutticketenum = statutticketenumRepository.save(statutticketenum);
        return statutticketenumMapper.toDto(statutticketenum);
    }

    /**
     * Get all the statutticketenums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<StatutticketenumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Statutticketenums");
        return statutticketenumRepository.findAll(pageable)
            .map(statutticketenumMapper::toDto);
    }


    /**
     * Get one statutticketenum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<StatutticketenumDTO> findOne(Long id) {
        log.debug("Request to get Statutticketenum : {}", id);
        return statutticketenumRepository.findById(id)
            .map(statutticketenumMapper::toDto);
    }

    /**
     * Delete the statutticketenum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Statutticketenum : {}", id);
        statutticketenumRepository.deleteById(id);
    }
}
