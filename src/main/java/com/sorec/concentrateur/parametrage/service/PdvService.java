package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Pdv;
import com.sorec.concentrateur.parametrage.repository.PdvRepository;
import com.sorec.concentrateur.parametrage.service.dto.PdvDTO;
import com.sorec.concentrateur.parametrage.service.mapper.PdvMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Pdv}.
 */
@Service
@Transactional
public class PdvService {

    private final Logger log = LoggerFactory.getLogger(PdvService.class);

    private final PdvRepository pdvRepository;

    private final PdvMapper pdvMapper;

    public PdvService(PdvRepository pdvRepository, PdvMapper pdvMapper) {
        this.pdvRepository = pdvRepository;
        this.pdvMapper = pdvMapper;
    }

    /**
     * Save a pdv.
     *
     * @param pdvDTO the entity to save.
     * @return the persisted entity.
     */
    public PdvDTO save(PdvDTO pdvDTO) {
        log.debug("Request to save Pdv : {}", pdvDTO);
        Pdv pdv = pdvMapper.toEntity(pdvDTO);
        pdv = pdvRepository.save(pdv);
        return pdvMapper.toDto(pdv);
    }

    /**
     * Get all the pdvs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PdvDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Pdvs");
        return pdvRepository.findAll(pageable)
            .map(pdvMapper::toDto);
    }


    /**
     * Get one pdv by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PdvDTO> findOne(Long id) {
        log.debug("Request to get Pdv : {}", id);
        return pdvRepository.findById(id)
            .map(pdvMapper::toDto);
    }

    /**
     * Delete the pdv by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Pdv : {}", id);
        pdvRepository.deleteById(id);
    }
}
