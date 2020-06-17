package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.StatutticketenumService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.StatutticketenumDTO;
import com.sorec.concentrateur.parametrage.service.dto.StatutticketenumCriteria;
import com.sorec.concentrateur.parametrage.service.StatutticketenumQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Statutticketenum}.
 */
@RestController
@RequestMapping("/api")
public class StatutticketenumResource {

    private final Logger log = LoggerFactory.getLogger(StatutticketenumResource.class);

    private static final String ENTITY_NAME = "parametrageStatutticketenum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StatutticketenumService statutticketenumService;

    private final StatutticketenumQueryService statutticketenumQueryService;

    public StatutticketenumResource(StatutticketenumService statutticketenumService, StatutticketenumQueryService statutticketenumQueryService) {
        this.statutticketenumService = statutticketenumService;
        this.statutticketenumQueryService = statutticketenumQueryService;
    }

    /**
     * {@code POST  /statutticketenums} : Create a new statutticketenum.
     *
     * @param statutticketenumDTO the statutticketenumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new statutticketenumDTO, or with status {@code 400 (Bad Request)} if the statutticketenum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/statutticketenums")
    public ResponseEntity<StatutticketenumDTO> createStatutticketenum(@Valid @RequestBody StatutticketenumDTO statutticketenumDTO) throws URISyntaxException {
        log.debug("REST request to save Statutticketenum : {}", statutticketenumDTO);
        if (statutticketenumDTO.getId() != null) {
            throw new BadRequestAlertException("A new statutticketenum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StatutticketenumDTO result = statutticketenumService.save(statutticketenumDTO);
        return ResponseEntity.created(new URI("/api/statutticketenums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /statutticketenums} : Updates an existing statutticketenum.
     *
     * @param statutticketenumDTO the statutticketenumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated statutticketenumDTO,
     * or with status {@code 400 (Bad Request)} if the statutticketenumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the statutticketenumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/statutticketenums")
    public ResponseEntity<StatutticketenumDTO> updateStatutticketenum(@Valid @RequestBody StatutticketenumDTO statutticketenumDTO) throws URISyntaxException {
        log.debug("REST request to update Statutticketenum : {}", statutticketenumDTO);
        if (statutticketenumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StatutticketenumDTO result = statutticketenumService.save(statutticketenumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, statutticketenumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /statutticketenums} : get all the statutticketenums.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of statutticketenums in body.
     */
    @GetMapping("/statutticketenums")
    public ResponseEntity<List<StatutticketenumDTO>> getAllStatutticketenums(StatutticketenumCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Statutticketenums by criteria: {}", criteria);
        Page<StatutticketenumDTO> page = statutticketenumQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /statutticketenums/count} : count all the statutticketenums.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/statutticketenums/count")
    public ResponseEntity<Long> countStatutticketenums(StatutticketenumCriteria criteria) {
        log.debug("REST request to count Statutticketenums by criteria: {}", criteria);
        return ResponseEntity.ok().body(statutticketenumQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /statutticketenums/:id} : get the "id" statutticketenum.
     *
     * @param id the id of the statutticketenumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the statutticketenumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/statutticketenums/{id}")
    public ResponseEntity<StatutticketenumDTO> getStatutticketenum(@PathVariable Long id) {
        log.debug("REST request to get Statutticketenum : {}", id);
        Optional<StatutticketenumDTO> statutticketenumDTO = statutticketenumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(statutticketenumDTO);
    }

    /**
     * {@code DELETE  /statutticketenums/:id} : delete the "id" statutticketenum.
     *
     * @param id the id of the statutticketenumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/statutticketenums/{id}")
    public ResponseEntity<Void> deleteStatutticketenum(@PathVariable Long id) {
        log.debug("REST request to delete Statutticketenum : {}", id);
        statutticketenumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
