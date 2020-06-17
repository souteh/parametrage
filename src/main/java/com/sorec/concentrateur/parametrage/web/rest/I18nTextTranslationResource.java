package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.I18nTextTranslationService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.I18nTextTranslationDTO;
import com.sorec.concentrateur.parametrage.service.dto.I18nTextTranslationCriteria;
import com.sorec.concentrateur.parametrage.service.I18nTextTranslationQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.I18nTextTranslation}.
 */
@RestController
@RequestMapping("/api")
public class I18nTextTranslationResource {

    private final Logger log = LoggerFactory.getLogger(I18nTextTranslationResource.class);

    private static final String ENTITY_NAME = "parametrageI18NTextTranslation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final I18nTextTranslationService i18nTextTranslationService;

    private final I18nTextTranslationQueryService i18nTextTranslationQueryService;

    public I18nTextTranslationResource(I18nTextTranslationService i18nTextTranslationService, I18nTextTranslationQueryService i18nTextTranslationQueryService) {
        this.i18nTextTranslationService = i18nTextTranslationService;
        this.i18nTextTranslationQueryService = i18nTextTranslationQueryService;
    }

    /**
     * {@code POST  /i-18-n-text-translations} : Create a new i18nTextTranslation.
     *
     * @param i18nTextTranslationDTO the i18nTextTranslationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new i18nTextTranslationDTO, or with status {@code 400 (Bad Request)} if the i18nTextTranslation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/i-18-n-text-translations")
    public ResponseEntity<I18nTextTranslationDTO> createI18nTextTranslation(@Valid @RequestBody I18nTextTranslationDTO i18nTextTranslationDTO) throws URISyntaxException {
        log.debug("REST request to save I18nTextTranslation : {}", i18nTextTranslationDTO);
        if (i18nTextTranslationDTO.getId() != null) {
            throw new BadRequestAlertException("A new i18nTextTranslation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        I18nTextTranslationDTO result = i18nTextTranslationService.save(i18nTextTranslationDTO);
        return ResponseEntity.created(new URI("/api/i-18-n-text-translations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /i-18-n-text-translations} : Updates an existing i18nTextTranslation.
     *
     * @param i18nTextTranslationDTO the i18nTextTranslationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated i18nTextTranslationDTO,
     * or with status {@code 400 (Bad Request)} if the i18nTextTranslationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the i18nTextTranslationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/i-18-n-text-translations")
    public ResponseEntity<I18nTextTranslationDTO> updateI18nTextTranslation(@Valid @RequestBody I18nTextTranslationDTO i18nTextTranslationDTO) throws URISyntaxException {
        log.debug("REST request to update I18nTextTranslation : {}", i18nTextTranslationDTO);
        if (i18nTextTranslationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        I18nTextTranslationDTO result = i18nTextTranslationService.save(i18nTextTranslationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, i18nTextTranslationDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /i-18-n-text-translations} : get all the i18nTextTranslations.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of i18nTextTranslations in body.
     */
    @GetMapping("/i-18-n-text-translations")
    public ResponseEntity<List<I18nTextTranslationDTO>> getAllI18nTextTranslations(I18nTextTranslationCriteria criteria, Pageable pageable) {
        log.debug("REST request to get I18nTextTranslations by criteria: {}", criteria);
        Page<I18nTextTranslationDTO> page = i18nTextTranslationQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /i-18-n-text-translations/count} : count all the i18nTextTranslations.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/i-18-n-text-translations/count")
    public ResponseEntity<Long> countI18nTextTranslations(I18nTextTranslationCriteria criteria) {
        log.debug("REST request to count I18nTextTranslations by criteria: {}", criteria);
        return ResponseEntity.ok().body(i18nTextTranslationQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /i-18-n-text-translations/:id} : get the "id" i18nTextTranslation.
     *
     * @param id the id of the i18nTextTranslationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the i18nTextTranslationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/i-18-n-text-translations/{id}")
    public ResponseEntity<I18nTextTranslationDTO> getI18nTextTranslation(@PathVariable Long id) {
        log.debug("REST request to get I18nTextTranslation : {}", id);
        Optional<I18nTextTranslationDTO> i18nTextTranslationDTO = i18nTextTranslationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(i18nTextTranslationDTO);
    }

    /**
     * {@code DELETE  /i-18-n-text-translations/:id} : delete the "id" i18nTextTranslation.
     *
     * @param id the id of the i18nTextTranslationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/i-18-n-text-translations/{id}")
    public ResponseEntity<Void> deleteI18nTextTranslation(@PathVariable Long id) {
        log.debug("REST request to delete I18nTextTranslation : {}", id);
        i18nTextTranslationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
