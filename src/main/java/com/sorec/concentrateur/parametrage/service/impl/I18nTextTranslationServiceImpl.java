package com.sorec.concentrateur.parametrage.service.impl;

import com.sorec.concentrateur.parametrage.service.I18nTextTranslationService;
import com.sorec.concentrateur.parametrage.domain.I18nTextTranslation;
import com.sorec.concentrateur.parametrage.repository.I18nTextTranslationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link I18nTextTranslation}.
 */
@Service
@Transactional
public class I18nTextTranslationServiceImpl implements I18nTextTranslationService {

    private final Logger log = LoggerFactory.getLogger(I18nTextTranslationServiceImpl.class);

    private final I18nTextTranslationRepository i18nTextTranslationRepository;

    public I18nTextTranslationServiceImpl(I18nTextTranslationRepository i18nTextTranslationRepository) {
        this.i18nTextTranslationRepository = i18nTextTranslationRepository;
    }

    /**
     * Save a i18nTextTranslation.
     *
     * @param i18nTextTranslation the entity to save.
     * @return the persisted entity.
     */
    @Override
    public I18nTextTranslation save(I18nTextTranslation i18nTextTranslation) {
        log.debug("Request to save I18nTextTranslation : {}", i18nTextTranslation);
        return i18nTextTranslationRepository.save(i18nTextTranslation);
    }

    /**
     * Get all the i18nTextTranslations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<I18nTextTranslation> findAll(Pageable pageable) {
        log.debug("Request to get all I18nTextTranslations");
        return i18nTextTranslationRepository.findAll(pageable);
    }


    /**
     * Get one i18nTextTranslation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<I18nTextTranslation> findOne(Long id) {
        log.debug("Request to get I18nTextTranslation : {}", id);
        return i18nTextTranslationRepository.findById(id);
    }

    /**
     * Delete the i18nTextTranslation by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete I18nTextTranslation : {}", id);
        i18nTextTranslationRepository.deleteById(id);
    }
}
