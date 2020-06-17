package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.FormulationentityService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.FormulationentityDTO;
import com.sorec.concentrateur.parametrage.service.dto.FormulationentityCriteria;
import com.sorec.concentrateur.parametrage.service.FormulationentityQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Formulationentity}.
 */
@RestController
@RequestMapping("/api")
public class FormulationentityResource {

    private final Logger log = LoggerFactory.getLogger(FormulationentityResource.class);

    private static final String ENTITY_NAME = "parametrageFormulationentity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FormulationentityService formulationentityService;

    private final FormulationentityQueryService formulationentityQueryService;

    public FormulationentityResource(FormulationentityService formulationentityService, FormulationentityQueryService formulationentityQueryService) {
        this.formulationentityService = formulationentityService;
        this.formulationentityQueryService = formulationentityQueryService;
    }

    /**
     * {@code POST  /formulationentities} : Create a new formulationentity.
     *
     * @param formulationentityDTO the formulationentityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new formulationentityDTO, or with status {@code 400 (Bad Request)} if the formulationentity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/formulationentities")
    public ResponseEntity<FormulationentityDTO> createFormulationentity(@Valid @RequestBody FormulationentityDTO formulationentityDTO) throws URISyntaxException {
        log.debug("REST request to save Formulationentity : {}", formulationentityDTO);
        if (formulationentityDTO.getId() != null) {
            throw new BadRequestAlertException("A new formulationentity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FormulationentityDTO result = formulationentityService.save(formulationentityDTO);
        return ResponseEntity.created(new URI("/api/formulationentities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /formulationentities} : Updates an existing formulationentity.
     *
     * @param formulationentityDTO the formulationentityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated formulationentityDTO,
     * or with status {@code 400 (Bad Request)} if the formulationentityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the formulationentityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/formulationentities")
    public ResponseEntity<FormulationentityDTO> updateFormulationentity(@Valid @RequestBody FormulationentityDTO formulationentityDTO) throws URISyntaxException {
        log.debug("REST request to update Formulationentity : {}", formulationentityDTO);
        if (formulationentityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FormulationentityDTO result = formulationentityService.save(formulationentityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, formulationentityDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /formulationentities} : get all the formulationentities.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of formulationentities in body.
     */
    @GetMapping("/formulationentities")
    public ResponseEntity<List<FormulationentityDTO>> getAllFormulationentities(FormulationentityCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Formulationentities by criteria: {}", criteria);
        Page<FormulationentityDTO> page = formulationentityQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /formulationentities/count} : count all the formulationentities.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/formulationentities/count")
    public ResponseEntity<Long> countFormulationentities(FormulationentityCriteria criteria) {
        log.debug("REST request to count Formulationentities by criteria: {}", criteria);
        return ResponseEntity.ok().body(formulationentityQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /formulationentities/:id} : get the "id" formulationentity.
     *
     * @param id the id of the formulationentityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the formulationentityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/formulationentities/{id}")
    public ResponseEntity<FormulationentityDTO> getFormulationentity(@PathVariable Long id) {
        log.debug("REST request to get Formulationentity : {}", id);
        Optional<FormulationentityDTO> formulationentityDTO = formulationentityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(formulationentityDTO);
    }

    /**
     * {@code DELETE  /formulationentities/:id} : delete the "id" formulationentity.
     *
     * @param id the id of the formulationentityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/formulationentities/{id}")
    public ResponseEntity<Void> deleteFormulationentity(@PathVariable Long id) {
        log.debug("REST request to delete Formulationentity : {}", id);
        formulationentityService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
