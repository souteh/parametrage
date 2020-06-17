package com.sorec.concentrateur.parametrage.service;

import com.sorec.concentrateur.parametrage.domain.I18nTextTranslation;
import com.sorec.concentrateur.parametrage.repository.I18nTextTranslationRepository;
import com.sorec.concentrateur.parametrage.service.dto.I18nTextTranslationDTO;
import com.sorec.concentrateur.parametrage.service.mapper.I18nTextTranslationMapper;
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
public class I18nTextTranslationService {

    private final Logger log = LoggerFactory.getLogger(I18nTextTranslationService.class);

    private final I18nTextTranslationRepository i18nTextTranslationRepository;

    private final I18nTextTranslationMapper i18nTextTranslationMapper;

    public I18nTextTranslationService(I18nTextTranslationRepository i18nTextTranslationRepository, I18nTextTranslationMapper i18nTextTranslationMapper) {
        this.i18nTextTranslationRepository = i18nTextTranslationRepository;
        this.i18nTextTranslationMapper = i18nTextTranslationMapper;
    }

    /**
     * Save a i18nTextTranslation.
     *
     * @param i18nTextTranslationDTO the entity to save.
     * @return the persisted entity.
     */
    public I18nTextTranslationDTO save(I18nTextTranslationDTO i18nTextTranslationDTO) {
        log.debug("Request to save I18nTextTranslation : {}", i18nTextTranslationDTO);
        I18nTextTranslation i18nTextTranslation = i18nTextTranslationMapper.toEntity(i18nTextTranslationDTO);
        i18nTextTranslation = i18nTextTranslationRepository.save(i18nTextTranslation);
        return i18nTextTranslationMapper.toDto(i18nTextTranslation);
    }

    /**
     * Get all the i18nTextTranslations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<I18nTextTranslationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all I18nTextTranslations");
        return i18nTextTranslationRepository.findAll(pageable)
            .map(i18nTextTranslationMapper::toDto);
    }


    /**
     * Get one i18nTextTranslation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<I18nTextTranslationDTO> findOne(Long id) {
        log.debug("Request to get I18nTextTranslation : {}", id);
        return i18nTextTranslationRepository.findById(id)
            .map(i18nTextTranslationMapper::toDto);
    }

    /**
     * Delete the i18nTextTranslation by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete I18nTextTranslation : {}", id);
        i18nTextTranslationRepository.deleteById(id);
    }
}
