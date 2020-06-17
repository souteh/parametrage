package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typecanalenum;
import com.sorec.concentrateur.parametrage.repository.TypecanalenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypecanalenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypecanalenumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typecanalenum}.
 */
@Service
@Transactional
public class TypecanalenumService {

    private final Logger log = LoggerFactory.getLogger(TypecanalenumService.class);

    private final TypecanalenumRepository typecanalenumRepository;

    private final TypecanalenumMapper typecanalenumMapper;

    public TypecanalenumService(TypecanalenumRepository typecanalenumRepository, TypecanalenumMapper typecanalenumMapper) {
        this.typecanalenumRepository = typecanalenumRepository;
        this.typecanalenumMapper = typecanalenumMapper;
    }

    /**
     * Save a typecanalenum.
     *
     * @param typecanalenumDTO the entity to save.
     * @return the persisted entity.
     */
    public TypecanalenumDTO save(TypecanalenumDTO typecanalenumDTO) {
        log.debug("Request to save Typecanalenum : {}", typecanalenumDTO);
        Typecanalenum typecanalenum = typecanalenumMapper.toEntity(typecanalenumDTO);
        typecanalenum = typecanalenumRepository.save(typecanalenum);
        return typecanalenumMapper.toDto(typecanalenum);
    }

    /**
     * Get all the typecanalenums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TypecanalenumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Typecanalenums");
        return typecanalenumRepository.findAll(pageable)
            .map(typecanalenumMapper::toDto);
    }


    /**
     * Get one typecanalenum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TypecanalenumDTO> findOne(Long id) {
        log.debug("Request to get Typecanalenum : {}", id);
        return typecanalenumRepository.findById(id)
            .map(typecanalenumMapper::toDto);
    }

    /**
     * Delete the typecanalenum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typecanalenum : {}", id);
        typecanalenumRepository.deleteById(id);
    }
}
