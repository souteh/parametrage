package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.TypecanalenumService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.TypecanalenumDTO;
import com.sorec.concentrateur.parametrage.service.dto.TypecanalenumCriteria;
import com.sorec.concentrateur.parametrage.service.TypecanalenumQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Typecanalenum}.
 */
@RestController
@RequestMapping("/api")
public class TypecanalenumResource {

    private final Logger log = LoggerFactory.getLogger(TypecanalenumResource.class);

    private static final String ENTITY_NAME = "parametrageTypecanalenum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TypecanalenumService typecanalenumService;

    private final TypecanalenumQueryService typecanalenumQueryService;

    public TypecanalenumResource(TypecanalenumService typecanalenumService, TypecanalenumQueryService typecanalenumQueryService) {
        this.typecanalenumService = typecanalenumService;
        this.typecanalenumQueryService = typecanalenumQueryService;
    }

    /**
     * {@code POST  /typecanalenums} : Create a new typecanalenum.
     *
     * @param typecanalenumDTO the typecanalenumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new typecanalenumDTO, or with status {@code 400 (Bad Request)} if the typecanalenum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/typecanalenums")
    public ResponseEntity<TypecanalenumDTO> createTypecanalenum(@Valid @RequestBody TypecanalenumDTO typecanalenumDTO) throws URISyntaxException {
        log.debug("REST request to save Typecanalenum : {}", typecanalenumDTO);
        if (typecanalenumDTO.getId() != null) {
            throw new BadRequestAlertException("A new typecanalenum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypecanalenumDTO result = typecanalenumService.save(typecanalenumDTO);
        return ResponseEntity.created(new URI("/api/typecanalenums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /typecanalenums} : Updates an existing typecanalenum.
     *
     * @param typecanalenumDTO the typecanalenumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated typecanalenumDTO,
     * or with status {@code 400 (Bad Request)} if the typecanalenumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the typecanalenumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/typecanalenums")
    public ResponseEntity<TypecanalenumDTO> updateTypecanalenum(@Valid @RequestBody TypecanalenumDTO typecanalenumDTO) throws URISyntaxException {
        log.debug("REST request to update Typecanalenum : {}", typecanalenumDTO);
        if (typecanalenumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TypecanalenumDTO result = typecanalenumService.save(typecanalenumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, typecanalenumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /typecanalenums} : get all the typecanalenums.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of typecanalenums in body.
     */
    @GetMapping("/typecanalenums")
    public ResponseEntity<List<TypecanalenumDTO>> getAllTypecanalenums(TypecanalenumCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Typecanalenums by criteria: {}", criteria);
        Page<TypecanalenumDTO> page = typecanalenumQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /typecanalenums/count} : count all the typecanalenums.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/typecanalenums/count")
    public ResponseEntity<Long> countTypecanalenums(TypecanalenumCriteria criteria) {
        log.debug("REST request to count Typecanalenums by criteria: {}", criteria);
        return ResponseEntity.ok().body(typecanalenumQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /typecanalenums/:id} : get the "id" typecanalenum.
     *
     * @param id the id of the typecanalenumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the typecanalenumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/typecanalenums/{id}")
    public ResponseEntity<TypecanalenumDTO> getTypecanalenum(@PathVariable Long id) {
        log.debug("REST request to get Typecanalenum : {}", id);
        Optional<TypecanalenumDTO> typecanalenumDTO = typecanalenumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(typecanalenumDTO);
    }

    /**
     * {@code DELETE  /typecanalenums/:id} : delete the "id" typecanalenum.
     *
     * @param id the id of the typecanalenumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/typecanalenums/{id}")
    public ResponseEntity<Void> deleteTypecanalenum(@PathVariable Long id) {
        log.debug("REST request to delete Typecanalenum : {}", id);
        typecanalenumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
