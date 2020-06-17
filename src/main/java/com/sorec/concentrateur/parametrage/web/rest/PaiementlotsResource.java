package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.PaiementlotsService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.PaiementlotsDTO;
import com.sorec.concentrateur.parametrage.service.dto.PaiementlotsCriteria;
import com.sorec.concentrateur.parametrage.service.PaiementlotsQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Paiementlots}.
 */
@RestController
@RequestMapping("/api")
public class PaiementlotsResource {

    private final Logger log = LoggerFactory.getLogger(PaiementlotsResource.class);

    private static final String ENTITY_NAME = "parametragePaiementlots";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PaiementlotsService paiementlotsService;

    private final PaiementlotsQueryService paiementlotsQueryService;

    public PaiementlotsResource(PaiementlotsService paiementlotsService, PaiementlotsQueryService paiementlotsQueryService) {
        this.paiementlotsService = paiementlotsService;
        this.paiementlotsQueryService = paiementlotsQueryService;
    }

    /**
     * {@code POST  /paiementlots} : Create a new paiementlots.
     *
     * @param paiementlotsDTO the paiementlotsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paiementlotsDTO, or with status {@code 400 (Bad Request)} if the paiementlots has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/paiementlots")
    public ResponseEntity<PaiementlotsDTO> createPaiementlots(@Valid @RequestBody PaiementlotsDTO paiementlotsDTO) throws URISyntaxException {
        log.debug("REST request to save Paiementlots : {}", paiementlotsDTO);
        if (paiementlotsDTO.getId() != null) {
            throw new BadRequestAlertException("A new paiementlots cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PaiementlotsDTO result = paiementlotsService.save(paiementlotsDTO);
        return ResponseEntity.created(new URI("/api/paiementlots/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /paiementlots} : Updates an existing paiementlots.
     *
     * @param paiementlotsDTO the paiementlotsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paiementlotsDTO,
     * or with status {@code 400 (Bad Request)} if the paiementlotsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paiementlotsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/paiementlots")
    public ResponseEntity<PaiementlotsDTO> updatePaiementlots(@Valid @RequestBody PaiementlotsDTO paiementlotsDTO) throws URISyntaxException {
        log.debug("REST request to update Paiementlots : {}", paiementlotsDTO);
        if (paiementlotsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PaiementlotsDTO result = paiementlotsService.save(paiementlotsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, paiementlotsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /paiementlots} : get all the paiementlots.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paiementlots in body.
     */
    @GetMapping("/paiementlots")
    public ResponseEntity<List<PaiementlotsDTO>> getAllPaiementlots(PaiementlotsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Paiementlots by criteria: {}", criteria);
        Page<PaiementlotsDTO> page = paiementlotsQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /paiementlots/count} : count all the paiementlots.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/paiementlots/count")
    public ResponseEntity<Long> countPaiementlots(PaiementlotsCriteria criteria) {
        log.debug("REST request to count Paiementlots by criteria: {}", criteria);
        return ResponseEntity.ok().body(paiementlotsQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /paiementlots/:id} : get the "id" paiementlots.
     *
     * @param id the id of the paiementlotsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paiementlotsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/paiementlots/{id}")
    public ResponseEntity<PaiementlotsDTO> getPaiementlots(@PathVariable Long id) {
        log.debug("REST request to get Paiementlots : {}", id);
        Optional<PaiementlotsDTO> paiementlotsDTO = paiementlotsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paiementlotsDTO);
    }

    /**
     * {@code DELETE  /paiementlots/:id} : delete the "id" paiementlots.
     *
     * @param id the id of the paiementlotsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/paiementlots/{id}")
    public ResponseEntity<Void> deletePaiementlots(@PathVariable Long id) {
        log.debug("REST request to delete Paiementlots : {}", id);
        paiementlotsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
