package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Hypodrome;
import com.sorec.concentrateur.parametrage.repository.HypodromeRepository;
import com.sorec.concentrateur.parametrage.service.dto.HypodromeDTO;
import com.sorec.concentrateur.parametrage.service.mapper.HypodromeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Hypodrome}.
 */
@Service
@Transactional
public class HypodromeService {

    private final Logger log = LoggerFactory.getLogger(HypodromeService.class);

    private final HypodromeRepository hypodromeRepository;

    private final HypodromeMapper hypodromeMapper;

    public HypodromeService(HypodromeRepository hypodromeRepository, HypodromeMapper hypodromeMapper) {
        this.hypodromeRepository = hypodromeRepository;
        this.hypodromeMapper = hypodromeMapper;
    }

    /**
     * Save a hypodrome.
     *
     * @param hypodromeDTO the entity to save.
     * @return the persisted entity.
     */
    public HypodromeDTO save(HypodromeDTO hypodromeDTO) {
        log.debug("Request to save Hypodrome : {}", hypodromeDTO);
        Hypodrome hypodrome = hypodromeMapper.toEntity(hypodromeDTO);
        hypodrome = hypodromeRepository.save(hypodrome);
        return hypodromeMapper.toDto(hypodrome);
    }

    /**
     * Get all the hypodromes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<HypodromeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Hypodromes");
        return hypodromeRepository.findAll(pageable)
            .map(hypodromeMapper::toDto);
    }


    /**
     * Get one hypodrome by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<HypodromeDTO> findOne(Long id) {
        log.debug("Request to get Hypodrome : {}", id);
        return hypodromeRepository.findById(id)
            .map(hypodromeMapper::toDto);
    }

    /**
     * Delete the hypodrome by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Hypodrome : {}", id);
        hypodromeRepository.deleteById(id);
    }
}
