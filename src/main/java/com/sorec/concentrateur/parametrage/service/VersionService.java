package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.Version;
import com.sorec.concentrateur.parametrage.repository.VersionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Version}.
 */
@Service
@Transactional
public class VersionService {

    private final Logger log = LoggerFactory.getLogger(VersionService.class);

    private final VersionRepository versionRepository;

    public VersionService(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    /**
     * Save a version.
     *
     * @param version the entity to save.
     * @return the persisted entity.
     */
    public Version save(Version version) {
        log.debug("Request to save Version : {}", version);
        return versionRepository.save(version);
    }

    /**
     * Get all the versions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Version> findAll(Pageable pageable) {
        log.debug("Request to get all Versions");
        return versionRepository.findAll(pageable);
    }


    /**
     * Get one version by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Version> findOne(Long id) {
        log.debug("Request to get Version : {}", id);
        return versionRepository.findById(id);
    }

    /**
     * Delete the version by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Version : {}", id);
        versionRepository.deleteById(id);
    }
}
