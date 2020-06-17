package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Paiementlots;
import com.sorec.concentrateur.parametrage.repository.PaiementlotsRepository;
import com.sorec.concentrateur.parametrage.service.dto.PaiementlotsDTO;
import com.sorec.concentrateur.parametrage.service.mapper.PaiementlotsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Paiementlots}.
 */
@Service
@Transactional
public class PaiementlotsService {

    private final Logger log = LoggerFactory.getLogger(PaiementlotsService.class);

    private final PaiementlotsRepository paiementlotsRepository;

    private final PaiementlotsMapper paiementlotsMapper;

    public PaiementlotsService(PaiementlotsRepository paiementlotsRepository, PaiementlotsMapper paiementlotsMapper) {
        this.paiementlotsRepository = paiementlotsRepository;
        this.paiementlotsMapper = paiementlotsMapper;
    }

    /**
     * Save a paiementlots.
     *
     * @param paiementlotsDTO the entity to save.
     * @return the persisted entity.
     */
    public PaiementlotsDTO save(PaiementlotsDTO paiementlotsDTO) {
        log.debug("Request to save Paiementlots : {}", paiementlotsDTO);
        Paiementlots paiementlots = paiementlotsMapper.toEntity(paiementlotsDTO);
        paiementlots = paiementlotsRepository.save(paiementlots);
        return paiementlotsMapper.toDto(paiementlots);
    }

    /**
     * Get all the paiementlots.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PaiementlotsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Paiementlots");
        return paiementlotsRepository.findAll(pageable)
            .map(paiementlotsMapper::toDto);
    }


    /**
     * Get one paiementlots by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PaiementlotsDTO> findOne(Long id) {
        log.debug("Request to get Paiementlots : {}", id);
        return paiementlotsRepository.findById(id)
            .map(paiementlotsMapper::toDto);
    }

    /**
     * Delete the paiementlots by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Paiementlots : {}", id);
        paiementlotsRepository.deleteById(id);
    }
}
