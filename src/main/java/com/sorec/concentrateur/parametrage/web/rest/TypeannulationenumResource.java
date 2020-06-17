package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.TypeannulationenumService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.TypeannulationenumDTO;
import com.sorec.concentrateur.parametrage.service.dto.TypeannulationenumCriteria;
import com.sorec.concentrateur.parametrage.service.TypeannulationenumQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Typeannulationenum}.
 */
@RestController
@RequestMapping("/api")
public class TypeannulationenumResource {

    private final Logger log = LoggerFactory.getLogger(TypeannulationenumResource.class);

    private static final String ENTITY_NAME = "parametrageTypeannulationenum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TypeannulationenumService typeannulationenumService;

    private final TypeannulationenumQueryService typeannulationenumQueryService;

    public TypeannulationenumResource(TypeannulationenumService typeannulationenumService, TypeannulationenumQueryService typeannulationenumQueryService) {
        this.typeannulationenumService = typeannulationenumService;
        this.typeannulationenumQueryService = typeannulationenumQueryService;
    }

    /**
     * {@code POST  /typeannulationenums} : Create a new typeannulationenum.
     *
     * @param typeannulationenumDTO the typeannulationenumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new typeannulationenumDTO, or with status {@code 400 (Bad Request)} if the typeannulationenum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/typeannulationenums")
    public ResponseEntity<TypeannulationenumDTO> createTypeannulationenum(@Valid @RequestBody TypeannulationenumDTO typeannulationenumDTO) throws URISyntaxException {
        log.debug("REST request to save Typeannulationenum : {}", typeannulationenumDTO);
        if (typeannulationenumDTO.getId() != null) {
            throw new BadRequestAlertException("A new typeannulationenum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypeannulationenumDTO result = typeannulationenumService.save(typeannulationenumDTO);
        return ResponseEntity.created(new URI("/api/typeannulationenums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /typeannulationenums} : Updates an existing typeannulationenum.
     *
     * @param typeannulationenumDTO the typeannulationenumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated typeannulationenumDTO,
     * or with status {@code 400 (Bad Request)} if the typeannulationenumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the typeannulationenumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/typeannulationenums")
    public ResponseEntity<TypeannulationenumDTO> updateTypeannulationenum(@Valid @RequestBody TypeannulationenumDTO typeannulationenumDTO) throws URISyntaxException {
        log.debug("REST request to update Typeannulationenum : {}", typeannulationenumDTO);
        if (typeannulationenumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TypeannulationenumDTO result = typeannulationenumService.save(typeannulationenumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, typeannulationenumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /typeannulationenums} : get all the typeannulationenums.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of typeannulationenums in body.
     */
    @GetMapping("/typeannulationenums")
    public ResponseEntity<List<TypeannulationenumDTO>> getAllTypeannulationenums(TypeannulationenumCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Typeannulationenums by criteria: {}", criteria);
        Page<TypeannulationenumDTO> page = typeannulationenumQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /typeannulationenums/count} : count all the typeannulationenums.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/typeannulationenums/count")
    public ResponseEntity<Long> countTypeannulationenums(TypeannulationenumCriteria criteria) {
        log.debug("REST request to count Typeannulationenums by criteria: {}", criteria);
        return ResponseEntity.ok().body(typeannulationenumQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /typeannulationenums/:id} : get the "id" typeannulationenum.
     *
     * @param id the id of the typeannulationenumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the typeannulationenumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/typeannulationenums/{id}")
    public ResponseEntity<TypeannulationenumDTO> getTypeannulationenum(@PathVariable Long id) {
        log.debug("REST request to get Typeannulationenum : {}", id);
        Optional<TypeannulationenumDTO> typeannulationenumDTO = typeannulationenumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(typeannulationenumDTO);
    }

    /**
     * {@code DELETE  /typeannulationenums/:id} : delete the "id" typeannulationenum.
     *
     * @param id the id of the typeannulationenumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/typeannulationenums/{id}")
    public ResponseEntity<Void> deleteTypeannulationenum(@PathVariable Long id) {
        log.debug("REST request to delete Typeannulationenum : {}", id);
        typeannulationenumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
