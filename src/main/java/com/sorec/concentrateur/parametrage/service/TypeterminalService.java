package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typeterminal;
import com.sorec.concentrateur.parametrage.repository.TypeterminalRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypeterminalDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypeterminalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typeterminal}.
 */
@Service
@Transactional
public class TypeterminalService {

    private final Logger log = LoggerFactory.getLogger(TypeterminalService.class);

    private final TypeterminalRepository typeterminalRepository;

    private final TypeterminalMapper typeterminalMapper;

    public TypeterminalService(TypeterminalRepository typeterminalRepository, TypeterminalMapper typeterminalMapper) {
        this.typeterminalRepository = typeterminalRepository;
        this.typeterminalMapper = typeterminalMapper;
    }

    /**
     * Save a typeterminal.
     *
     * @param typeterminalDTO the entity to save.
     * @return the persisted entity.
     */
    public TypeterminalDTO save(TypeterminalDTO typeterminalDTO) {
        log.debug("Request to save Typeterminal : {}", typeterminalDTO);
        Typeterminal typeterminal = typeterminalMapper.toEntity(typeterminalDTO);
        typeterminal = typeterminalRepository.save(typeterminal);
        return typeterminalMapper.toDto(typeterminal);
    }

    /**
     * Get all the typeterminals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TypeterminalDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Typeterminals");
        return typeterminalRepository.findAll(pageable)
            .map(typeterminalMapper::toDto);
    }


    /**
     * Get one typeterminal by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TypeterminalDTO> findOne(Long id) {
        log.debug("Request to get Typeterminal : {}", id);
        return typeterminalRepository.findById(id)
            .map(typeterminalMapper::toDto);
    }

    /**
     * Delete the typeterminal by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typeterminal : {}", id);
        typeterminalRepository.deleteById(id);
    }
}
