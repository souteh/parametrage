package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.HypodromeService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.HypodromeDTO;
import com.sorec.concentrateur.parametrage.service.dto.HypodromeCriteria;
import com.sorec.concentrateur.parametrage.service.HypodromeQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Hypodrome}.
 */
@RestController
@RequestMapping("/api")
public class HypodromeResource {

    private final Logger log = LoggerFactory.getLogger(HypodromeResource.class);

    private static final String ENTITY_NAME = "parametrageHypodrome";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final HypodromeService hypodromeService;

    private final HypodromeQueryService hypodromeQueryService;

    public HypodromeResource(HypodromeService hypodromeService, HypodromeQueryService hypodromeQueryService) {
        this.hypodromeService = hypodromeService;
        this.hypodromeQueryService = hypodromeQueryService;
    }

    /**
     * {@code POST  /hypodromes} : Create a new hypodrome.
     *
     * @param hypodromeDTO the hypodromeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new hypodromeDTO, or with status {@code 400 (Bad Request)} if the hypodrome has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/hypodromes")
    public ResponseEntity<HypodromeDTO> createHypodrome(@Valid @RequestBody HypodromeDTO hypodromeDTO) throws URISyntaxException {
        log.debug("REST request to save Hypodrome : {}", hypodromeDTO);
        if (hypodromeDTO.getId() != null) {
            throw new BadRequestAlertException("A new hypodrome cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HypodromeDTO result = hypodromeService.save(hypodromeDTO);
        return ResponseEntity.created(new URI("/api/hypodromes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /hypodromes} : Updates an existing hypodrome.
     *
     * @param hypodromeDTO the hypodromeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated hypodromeDTO,
     * or with status {@code 400 (Bad Request)} if the hypodromeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the hypodromeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/hypodromes")
    public ResponseEntity<HypodromeDTO> updateHypodrome(@Valid @RequestBody HypodromeDTO hypodromeDTO) throws URISyntaxException {
        log.debug("REST request to update Hypodrome : {}", hypodromeDTO);
        if (hypodromeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        HypodromeDTO result = hypodromeService.save(hypodromeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, hypodromeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /hypodromes} : get all the hypodromes.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of hypodromes in body.
     */
    @GetMapping("/hypodromes")
    public ResponseEntity<List<HypodromeDTO>> getAllHypodromes(HypodromeCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Hypodromes by criteria: {}", criteria);
        Page<HypodromeDTO> page = hypodromeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /hypodromes/count} : count all the hypodromes.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/hypodromes/count")
    public ResponseEntity<Long> countHypodromes(HypodromeCriteria criteria) {
        log.debug("REST request to count Hypodromes by criteria: {}", criteria);
        return ResponseEntity.ok().body(hypodromeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /hypodromes/:id} : get the "id" hypodrome.
     *
     * @param id the id of the hypodromeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the hypodromeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/hypodromes/{id}")
    public ResponseEntity<HypodromeDTO> getHypodrome(@PathVariable Long id) {
        log.debug("REST request to get Hypodrome : {}", id);
        Optional<HypodromeDTO> hypodromeDTO = hypodromeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(hypodromeDTO);
    }

    /**
     * {@code DELETE  /hypodromes/:id} : delete the "id" hypodrome.
     *
     * @param id the id of the hypodromeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/hypodromes/{id}")
    public ResponseEntity<Void> deleteHypodrome(@PathVariable Long id) {
        log.debug("REST request to delete Hypodrome : {}", id);
        hypodromeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
