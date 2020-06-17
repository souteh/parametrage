package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typeoperationenum;
import com.sorec.concentrateur.parametrage.repository.TypeoperationenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypeoperationenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypeoperationenumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typeoperationenum}.
 */
@Service
@Transactional
public class TypeoperationenumService {

    private final Logger log = LoggerFactory.getLogger(TypeoperationenumService.class);

    private final TypeoperationenumRepository typeoperationenumRepository;

    private final TypeoperationenumMapper typeoperationenumMapper;

    public TypeoperationenumService(TypeoperationenumRepository typeoperationenumRepository, TypeoperationenumMapper typeoperationenumMapper) {
        this.typeoperationenumRepository = typeoperationenumRepository;
        this.typeoperationenumMapper = typeoperationenumMapper;
    }

    /**
     * Save a typeoperationenum.
     *
     * @param typeoperationenumDTO the entity to save.
     * @return the persisted entity.
     */
    public TypeoperationenumDTO save(TypeoperationenumDTO typeoperationenumDTO) {
        log.debug("Request to save Typeoperationenum : {}", typeoperationenumDTO);
        Typeoperationenum typeoperationenum = typeoperationenumMapper.toEntity(typeoperationenumDTO);
        typeoperationenum = typeoperationenumRepository.save(typeoperationenum);
        return typeoperationenumMapper.toDto(typeoperationenum);
    }

    /**
     * Get all the typeoperationenums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TypeoperationenumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Typeoperationenums");
        return typeoperationenumRepository.findAll(pageable)
            .map(typeoperationenumMapper::toDto);
    }


    /**
     * Get one typeoperationenum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TypeoperationenumDTO> findOne(Long id) {
        log.debug("Request to get Typeoperationenum : {}", id);
        return typeoperationenumRepository.findById(id)
            .map(typeoperationenumMapper::toDto);
    }

    /**
     * Delete the typeoperationenum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typeoperationenum : {}", id);
        typeoperationenumRepository.deleteById(id);
    }
}
