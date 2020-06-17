package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.TypeterminalenumService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.TypeterminalenumDTO;
import com.sorec.concentrateur.parametrage.service.dto.TypeterminalenumCriteria;
import com.sorec.concentrateur.parametrage.service.TypeterminalenumQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Typeterminalenum}.
 */
@RestController
@RequestMapping("/api")
public class TypeterminalenumResource {

    private final Logger log = LoggerFactory.getLogger(TypeterminalenumResource.class);

    private static final String ENTITY_NAME = "parametrageTypeterminalenum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TypeterminalenumService typeterminalenumService;

    private final TypeterminalenumQueryService typeterminalenumQueryService;

    public TypeterminalenumResource(TypeterminalenumService typeterminalenumService, TypeterminalenumQueryService typeterminalenumQueryService) {
        this.typeterminalenumService = typeterminalenumService;
        this.typeterminalenumQueryService = typeterminalenumQueryService;
    }

    /**
     * {@code POST  /typeterminalenums} : Create a new typeterminalenum.
     *
     * @param typeterminalenumDTO the typeterminalenumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new typeterminalenumDTO, or with status {@code 400 (Bad Request)} if the typeterminalenum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/typeterminalenums")
    public ResponseEntity<TypeterminalenumDTO> createTypeterminalenum(@Valid @RequestBody TypeterminalenumDTO typeterminalenumDTO) throws URISyntaxException {
        log.debug("REST request to save Typeterminalenum : {}", typeterminalenumDTO);
        if (typeterminalenumDTO.getId() != null) {
            throw new BadRequestAlertException("A new typeterminalenum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypeterminalenumDTO result = typeterminalenumService.save(typeterminalenumDTO);
        return ResponseEntity.created(new URI("/api/typeterminalenums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /typeterminalenums} : Updates an existing typeterminalenum.
     *
     * @param typeterminalenumDTO the typeterminalenumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated typeterminalenumDTO,
     * or with status {@code 400 (Bad Request)} if the typeterminalenumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the typeterminalenumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/typeterminalenums")
    public ResponseEntity<TypeterminalenumDTO> updateTypeterminalenum(@Valid @RequestBody TypeterminalenumDTO typeterminalenumDTO) throws URISyntaxException {
        log.debug("REST request to update Typeterminalenum : {}", typeterminalenumDTO);
        if (typeterminalenumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TypeterminalenumDTO result = typeterminalenumService.save(typeterminalenumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, typeterminalenumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /typeterminalenums} : get all the typeterminalenums.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of typeterminalenums in body.
     */
    @GetMapping("/typeterminalenums")
    public ResponseEntity<List<TypeterminalenumDTO>> getAllTypeterminalenums(TypeterminalenumCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Typeterminalenums by criteria: {}", criteria);
        Page<TypeterminalenumDTO> page = typeterminalenumQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /typeterminalenums/count} : count all the typeterminalenums.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/typeterminalenums/count")
    public ResponseEntity<Long> countTypeterminalenums(TypeterminalenumCriteria criteria) {
        log.debug("REST request to count Typeterminalenums by criteria: {}", criteria);
        return ResponseEntity.ok().body(typeterminalenumQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /typeterminalenums/:id} : get the "id" typeterminalenum.
     *
     * @param id the id of the typeterminalenumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the typeterminalenumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/typeterminalenums/{id}")
    public ResponseEntity<TypeterminalenumDTO> getTypeterminalenum(@PathVariable Long id) {
        log.debug("REST request to get Typeterminalenum : {}", id);
        Optional<TypeterminalenumDTO> typeterminalenumDTO = typeterminalenumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(typeterminalenumDTO);
    }

    /**
     * {@code DELETE  /typeterminalenums/:id} : delete the "id" typeterminalenum.
     *
     * @param id the id of the typeterminalenumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/typeterminalenums/{id}")
    public ResponseEntity<Void> deleteTypeterminalenum(@PathVariable Long id) {
        log.debug("REST request to delete Typeterminalenum : {}", id);
        typeterminalenumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
