package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.TypeterminalService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.TypeterminalDTO;
import com.sorec.concentrateur.parametrage.service.dto.TypeterminalCriteria;
import com.sorec.concentrateur.parametrage.service.TypeterminalQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Typeterminal}.
 */
@RestController
@RequestMapping("/api")
public class TypeterminalResource {

    private final Logger log = LoggerFactory.getLogger(TypeterminalResource.class);

    private static final String ENTITY_NAME = "parametrageTypeterminal";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TypeterminalService typeterminalService;

    private final TypeterminalQueryService typeterminalQueryService;

    public TypeterminalResource(TypeterminalService typeterminalService, TypeterminalQueryService typeterminalQueryService) {
        this.typeterminalService = typeterminalService;
        this.typeterminalQueryService = typeterminalQueryService;
    }

    /**
     * {@code POST  /typeterminals} : Create a new typeterminal.
     *
     * @param typeterminalDTO the typeterminalDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new typeterminalDTO, or with status {@code 400 (Bad Request)} if the typeterminal has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/typeterminals")
    public ResponseEntity<TypeterminalDTO> createTypeterminal(@Valid @RequestBody TypeterminalDTO typeterminalDTO) throws URISyntaxException {
        log.debug("REST request to save Typeterminal : {}", typeterminalDTO);
        if (typeterminalDTO.getId() != null) {
            throw new BadRequestAlertException("A new typeterminal cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypeterminalDTO result = typeterminalService.save(typeterminalDTO);
        return ResponseEntity.created(new URI("/api/typeterminals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /typeterminals} : Updates an existing typeterminal.
     *
     * @param typeterminalDTO the typeterminalDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated typeterminalDTO,
     * or with status {@code 400 (Bad Request)} if the typeterminalDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the typeterminalDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/typeterminals")
    public ResponseEntity<TypeterminalDTO> updateTypeterminal(@Valid @RequestBody TypeterminalDTO typeterminalDTO) throws URISyntaxException {
        log.debug("REST request to update Typeterminal : {}", typeterminalDTO);
        if (typeterminalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TypeterminalDTO result = typeterminalService.save(typeterminalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, typeterminalDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /typeterminals} : get all the typeterminals.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of typeterminals in body.
     */
    @GetMapping("/typeterminals")
    public ResponseEntity<List<TypeterminalDTO>> getAllTypeterminals(TypeterminalCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Typeterminals by criteria: {}", criteria);
        Page<TypeterminalDTO> page = typeterminalQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /typeterminals/count} : count all the typeterminals.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/typeterminals/count")
    public ResponseEntity<Long> countTypeterminals(TypeterminalCriteria criteria) {
        log.debug("REST request to count Typeterminals by criteria: {}", criteria);
        return ResponseEntity.ok().body(typeterminalQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /typeterminals/:id} : get the "id" typeterminal.
     *
     * @param id the id of the typeterminalDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the typeterminalDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/typeterminals/{id}")
    public ResponseEntity<TypeterminalDTO> getTypeterminal(@PathVariable Long id) {
        log.debug("REST request to get Typeterminal : {}", id);
        Optional<TypeterminalDTO> typeterminalDTO = typeterminalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(typeterminalDTO);
    }

    /**
     * {@code DELETE  /typeterminals/:id} : delete the "id" typeterminal.
     *
     * @param id the id of the typeterminalDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/typeterminals/{id}")
    public ResponseEntity<Void> deleteTypeterminal(@PathVariable Long id) {
        log.debug("REST request to delete Typeterminal : {}", id);
        typeterminalService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
