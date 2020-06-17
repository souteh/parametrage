package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Choisit;
import com.sorec.concentrateur.parametrage.repository.ChoisitRepository;
import com.sorec.concentrateur.parametrage.service.dto.ChoisitDTO;
import com.sorec.concentrateur.parametrage.service.mapper.ChoisitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Choisit}.
 */
@Service
@Transactional
public class ChoisitService {

    private final Logger log = LoggerFactory.getLogger(ChoisitService.class);

    private final ChoisitRepository choisitRepository;

    private final ChoisitMapper choisitMapper;

    public ChoisitService(ChoisitRepository choisitRepository, ChoisitMapper choisitMapper) {
        this.choisitRepository = choisitRepository;
        this.choisitMapper = choisitMapper;
    }

    /**
     * Save a choisit.
     *
     * @param choisitDTO the entity to save.
     * @return the persisted entity.
     */
    public ChoisitDTO save(ChoisitDTO choisitDTO) {
        log.debug("Request to save Choisit : {}", choisitDTO);
        Choisit choisit = choisitMapper.toEntity(choisitDTO);
        choisit = choisitRepository.save(choisit);
        return choisitMapper.toDto(choisit);
    }

    /**
     * Get all the choisits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ChoisitDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Choisits");
        return choisitRepository.findAll(pageable)
            .map(choisitMapper::toDto);
    }


    /**
     * Get one choisit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ChoisitDTO> findOne(Long id) {
        log.debug("Request to get Choisit : {}", id);
        return choisitRepository.findById(id)
            .map(choisitMapper::toDto);
    }

    /**
     * Delete the choisit by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Choisit : {}", id);
        choisitRepository.deleteById(id);
    }
}
