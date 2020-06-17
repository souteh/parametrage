package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typepaiementenum;
import com.sorec.concentrateur.parametrage.repository.TypepaiementenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypepaiementenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypepaiementenumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typepaiementenum}.
 */
@Service
@Transactional
public class TypepaiementenumService {

    private final Logger log = LoggerFactory.getLogger(TypepaiementenumService.class);

    private final TypepaiementenumRepository typepaiementenumRepository;

    private final TypepaiementenumMapper typepaiementenumMapper;

    public TypepaiementenumService(TypepaiementenumRepository typepaiementenumRepository, TypepaiementenumMapper typepaiementenumMapper) {
        this.typepaiementenumRepository = typepaiementenumRepository;
        this.typepaiementenumMapper = typepaiementenumMapper;
    }

    /**
     * Save a typepaiementenum.
     *
     * @param typepaiementenumDTO the entity to save.
     * @return the persisted entity.
     */
    public TypepaiementenumDTO save(TypepaiementenumDTO typepaiementenumDTO) {
        log.debug("Request to save Typepaiementenum : {}", typepaiementenumDTO);
        Typepaiementenum typepaiementenum = typepaiementenumMapper.toEntity(typepaiementenumDTO);
        typepaiementenum = typepaiementenumRepository.save(typepaiementenum);
        return typepaiementenumMapper.toDto(typepaiementenum);
    }

    /**
     * Get all the typepaiementenums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TypepaiementenumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Typepaiementenums");
        return typepaiementenumRepository.findAll(pageable)
            .map(typepaiementenumMapper::toDto);
    }


    /**
     * Get one typepaiementenum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TypepaiementenumDTO> findOne(Long id) {
        log.debug("Request to get Typepaiementenum : {}", id);
        return typepaiementenumRepository.findById(id)
            .map(typepaiementenumMapper::toDto);
    }

    /**
     * Delete the typepaiementenum by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typepaiementenum : {}", id);
        typepaiementenumRepository.deleteById(id);
    }
}
