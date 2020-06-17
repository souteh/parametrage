package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.TypeoperationenumService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.TypeoperationenumDTO;
import com.sorec.concentrateur.parametrage.service.dto.TypeoperationenumCriteria;
import com.sorec.concentrateur.parametrage.service.TypeoperationenumQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Typeoperationenum}.
 */
@RestController
@RequestMapping("/api")
public class TypeoperationenumResource {

    private final Logger log = LoggerFactory.getLogger(TypeoperationenumResource.class);

    private static final String ENTITY_NAME = "parametrageTypeoperationenum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TypeoperationenumService typeoperationenumService;

    private final TypeoperationenumQueryService typeoperationenumQueryService;

    public TypeoperationenumResource(TypeoperationenumService typeoperationenumService, TypeoperationenumQueryService typeoperationenumQueryService) {
        this.typeoperationenumService = typeoperationenumService;
        this.typeoperationenumQueryService = typeoperationenumQueryService;
    }

    /**
     * {@code POST  /typeoperationenums} : Create a new typeoperationenum.
     *
     * @param typeoperationenumDTO the typeoperationenumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new typeoperationenumDTO, or with status {@code 400 (Bad Request)} if the typeoperationenum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/typeoperationenums")
    public ResponseEntity<TypeoperationenumDTO> createTypeoperationenum(@Valid @RequestBody TypeoperationenumDTO typeoperationenumDTO) throws URISyntaxException {
        log.debug("REST request to save Typeoperationenum : {}", typeoperationenumDTO);
        if (typeoperationenumDTO.getId() != null) {
            throw new BadRequestAlertException("A new typeoperationenum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypeoperationenumDTO result = typeoperationenumService.save(typeoperationenumDTO);
        return ResponseEntity.created(new URI("/api/typeoperationenums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /typeoperationenums} : Updates an existing typeoperationenum.
     *
     * @param typeoperationenumDTO the typeoperationenumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated typeoperationenumDTO,
     * or with status {@code 400 (Bad Request)} if the typeoperationenumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the typeoperationenumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/typeoperationenums")
    public ResponseEntity<TypeoperationenumDTO> updateTypeoperationenum(@Valid @RequestBody TypeoperationenumDTO typeoperationenumDTO) throws URISyntaxException {
        log.debug("REST request to update Typeoperationenum : {}", typeoperationenumDTO);
        if (typeoperationenumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TypeoperationenumDTO result = typeoperationenumService.save(typeoperationenumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, typeoperationenumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /typeoperationenums} : get all the typeoperationenums.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of typeoperationenums in body.
     */
    @GetMapping("/typeoperationenums")
    public ResponseEntity<List<TypeoperationenumDTO>> getAllTypeoperationenums(TypeoperationenumCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Typeoperationenums by criteria: {}", criteria);
        Page<TypeoperationenumDTO> page = typeoperationenumQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /typeoperationenums/count} : count all the typeoperationenums.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/typeoperationenums/count")
    public ResponseEntity<Long> countTypeoperationenums(TypeoperationenumCriteria criteria) {
        log.debug("REST request to count Typeoperationenums by criteria: {}", criteria);
        return ResponseEntity.ok().body(typeoperationenumQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /typeoperationenums/:id} : get the "id" typeoperationenum.
     *
     * @param id the id of the typeoperationenumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the typeoperationenumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/typeoperationenums/{id}")
    public ResponseEntity<TypeoperationenumDTO> getTypeoperationenum(@PathVariable Long id) {
        log.debug("REST request to get Typeoperationenum : {}", id);
        Optional<TypeoperationenumDTO> typeoperationenumDTO = typeoperationenumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(typeoperationenumDTO);
    }

    /**
     * {@code DELETE  /typeoperationenums/:id} : delete the "id" typeoperationenum.
     *
     * @param id the id of the typeoperationenumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/typeoperationenums/{id}")
    public ResponseEntity<Void> deleteTypeoperationenum(@PathVariable Long id) {
        log.debug("REST request to delete Typeoperationenum : {}", id);
        typeoperationenumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
