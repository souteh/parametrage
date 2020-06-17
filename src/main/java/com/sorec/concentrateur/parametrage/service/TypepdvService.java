package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Typepdv;
import com.sorec.concentrateur.parametrage.repository.TypepdvRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Typepdv}.
 */
@Service
@Transactional
public class TypepdvService {

    private final Logger log = LoggerFactory.getLogger(TypepdvService.class);

    private final TypepdvRepository typepdvRepository;

    public TypepdvService(TypepdvRepository typepdvRepository) {
        this.typepdvRepository = typepdvRepository;
    }

    /**
     * Save a typepdv.
     *
     * @param typepdv the entity to save.
     * @return the persisted entity.
     */
    public Typepdv save(Typepdv typepdv) {
        log.debug("Request to save Typepdv : {}", typepdv);
        return typepdvRepository.save(typepdv);
    }

    /**
     * Get all the typepdvs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Typepdv> findAll(Pageable pageable) {
        log.debug("Request to get all Typepdvs");
        return typepdvRepository.findAll(pageable);
    }


    /**
     * Get one typepdv by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Typepdv> findOne(Long id) {
        log.debug("Request to get Typepdv : {}", id);
        return typepdvRepository.findById(id);
    }

    /**
     * Delete the typepdv by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Typepdv : {}", id);
        typepdvRepository.deleteById(id);
    }
}
