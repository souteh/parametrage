package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Pdventity;
import com.sorec.concentrateur.parametrage.repository.PdventityRepository;
import com.sorec.concentrateur.parametrage.service.dto.PdventityDTO;
import com.sorec.concentrateur.parametrage.service.mapper.PdventityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Pdventity}.
 */
@Service
@Transactional
public class PdventityService {

    private final Logger log = LoggerFactory.getLogger(PdventityService.class);

    private final PdventityRepository pdventityRepository;

    private final PdventityMapper pdventityMapper;

    public PdventityService(PdventityRepository pdventityRepository, PdventityMapper pdventityMapper) {
        this.pdventityRepository = pdventityRepository;
        this.pdventityMapper = pdventityMapper;
    }

    /**
     * Save a pdventity.
     *
     * @param pdventityDTO the entity to save.
     * @return the persisted entity.
     */
    public PdventityDTO save(PdventityDTO pdventityDTO) {
        log.debug("Request to save Pdventity : {}", pdventityDTO);
        Pdventity pdventity = pdventityMapper.toEntity(pdventityDTO);
        pdventity = pdventityRepository.save(pdventity);
        return pdventityMapper.toDto(pdventity);
    }

    /**
     * Get all the pdventities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PdventityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Pdventities");
        return pdventityRepository.findAll(pageable)
            .map(pdventityMapper::toDto);
    }


    /**
     * Get one pdventity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PdventityDTO> findOne(Long id) {
        log.debug("Request to get Pdventity : {}", id);
        return pdventityRepository.findById(id)
            .map(pdventityMapper::toDto);
    }

    /**
     * Delete the pdventity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Pdventity : {}", id);
        pdventityRepository.deleteById(id);
    }
}
