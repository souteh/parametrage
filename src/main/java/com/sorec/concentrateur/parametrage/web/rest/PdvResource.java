package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.PdvService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.PdvDTO;
import com.sorec.concentrateur.parametrage.service.dto.PdvCriteria;
import com.sorec.concentrateur.parametrage.service.PdvQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Pdv}.
 */
@RestController
@RequestMapping("/api")
public class PdvResource {

    private final Logger log = LoggerFactory.getLogger(PdvResource.class);

    private static final String ENTITY_NAME = "parametragePdv";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PdvService pdvService;

    private final PdvQueryService pdvQueryService;

    public PdvResource(PdvService pdvService, PdvQueryService pdvQueryService) {
        this.pdvService = pdvService;
        this.pdvQueryService = pdvQueryService;
    }

    /**
     * {@code POST  /pdvs} : Create a new pdv.
     *
     * @param pdvDTO the pdvDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pdvDTO, or with status {@code 400 (Bad Request)} if the pdv has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pdvs")
    public ResponseEntity<PdvDTO> createPdv(@Valid @RequestBody PdvDTO pdvDTO) throws URISyntaxException {
        log.debug("REST request to save Pdv : {}", pdvDTO);
        if (pdvDTO.getId() != null) {
            throw new BadRequestAlertException("A new pdv cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PdvDTO result = pdvService.save(pdvDTO);
        return ResponseEntity.created(new URI("/api/pdvs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /pdvs} : Updates an existing pdv.
     *
     * @param pdvDTO the pdvDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pdvDTO,
     * or with status {@code 400 (Bad Request)} if the pdvDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pdvDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pdvs")
    public ResponseEntity<PdvDTO> updatePdv(@Valid @RequestBody PdvDTO pdvDTO) throws URISyntaxException {
        log.debug("REST request to update Pdv : {}", pdvDTO);
        if (pdvDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PdvDTO result = pdvService.save(pdvDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pdvDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pdvs} : get all the pdvs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pdvs in body.
     */
    @GetMapping("/pdvs")
    public ResponseEntity<List<PdvDTO>> getAllPdvs(PdvCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Pdvs by criteria: {}", criteria);
        Page<PdvDTO> page = pdvQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pdvs/count} : count all the pdvs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/pdvs/count")
    public ResponseEntity<Long> countPdvs(PdvCriteria criteria) {
        log.debug("REST request to count Pdvs by criteria: {}", criteria);
        return ResponseEntity.ok().body(pdvQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /pdvs/:id} : get the "id" pdv.
     *
     * @param id the id of the pdvDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pdvDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pdvs/{id}")
    public ResponseEntity<PdvDTO> getPdv(@PathVariable Long id) {
        log.debug("REST request to get Pdv : {}", id);
        Optional<PdvDTO> pdvDTO = pdvService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pdvDTO);
    }

    /**
     * {@code DELETE  /pdvs/:id} : delete the "id" pdv.
     *
     * @param id the id of the pdvDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pdvs/{id}")
    public ResponseEntity<Void> deletePdv(@PathVariable Long id) {
        log.debug("REST request to delete Pdv : {}", id);
        pdvService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
