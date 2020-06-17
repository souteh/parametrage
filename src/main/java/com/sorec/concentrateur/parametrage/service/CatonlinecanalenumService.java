package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Catonlinecanalenum;
import com.sorec.concentrateur.parametrage.repository.CatonlinecanalenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.CatonlinecanalenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.CatonlinecanalenumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Catonlinecanalenum}.
 */
@Service
@Transactional
public class CatonlinecanalenumService {

    private final Logger log = LoggerFactory.getLogger(CatonlinecanalenumService.class);

    private final CatonlinecanalenumRepository catonlinecanalenumRepository;

    private final CatonlinecanalenumMapper catonlinecanalenumMapper;

    public CatonlinecanalenumService(CatonlinecanalenumRepository catonlinecanalenumRepository, CatonlinecanalenumMapper catonlinecanalenumMapper) {
        this.catonlinecanalenumRepository = catonlinecanalenumRepository;
        this.catonlinecanalenumMapper = catonlinecanalenumMapper;
    }

    /**
     * Save a catonlinecanalenum.
     *
     * @param catonlinecanalenumDTO the entity to save.
     * @return the persisted entity.
     */
    public CatonlinecanalenumDTO save(CatonlinecanalenumDTO catonlinecanalenumDTO) {
        log.debug("Request to save Catonlinecanalenum : {}", catonlinecanalenumDTO);
        Catonlinecanalenum catonlinecanalenum = catonlinecanalenumMapper.toEntity(catonlinecanalenumDTO);
        catonlinecanalenum = catonlinecanalenumRepository.save(catonlinecanalenum);
        return catonlinecanalenumMapper.toDto(catonlinecanalenum);
    }

    /**
     * Get all the catonlinecanalenums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CatonlinecanalenumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Catonlinecanalenums");
        return catonlinecanalenumRepository.findAll(pageable)
            .map(catonlinecanalenumMapper::toDto);
    }


    /**
     * Get one catonlinecanalenum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CatonlinecanalenumDTO> findOne(Long id) {
        log.debug("Request to get Catonlinecanalenum : {}", id);
        return catonlinecanalenumRepository.findById(id)
            .map(catonlinecanalenumMapper::toDto);
    }

    /**
     * Delete the catonlinecanalenum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Catonlinecanalenum : {}", id);
        catonlinecanalenumRepository.deleteById(id);
    }
}
