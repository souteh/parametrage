package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.TypepdvService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.TypepdvDTO;
import com.sorec.concentrateur.parametrage.service.dto.TypepdvCriteria;
import com.sorec.concentrateur.parametrage.service.TypepdvQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Typepdv}.
 */
@RestController
@RequestMapping("/api")
public class TypepdvResource {

    private final Logger log = LoggerFactory.getLogger(TypepdvResource.class);

    private static final String ENTITY_NAME = "parametrageTypepdv";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TypepdvService typepdvService;

    private final TypepdvQueryService typepdvQueryService;

    public TypepdvResource(TypepdvService typepdvService, TypepdvQueryService typepdvQueryService) {
        this.typepdvService = typepdvService;
        this.typepdvQueryService = typepdvQueryService;
    }

    /**
     * {@code POST  /typepdvs} : Create a new typepdv.
     *
     * @param typepdvDTO the typepdvDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new typepdvDTO, or with status {@code 400 (Bad Request)} if the typepdv has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/typepdvs")
    public ResponseEntity<TypepdvDTO> createTypepdv(@Valid @RequestBody TypepdvDTO typepdvDTO) throws URISyntaxException {
        log.debug("REST request to save Typepdv : {}", typepdvDTO);
        if (typepdvDTO.getId() != null) {
            throw new BadRequestAlertException("A new typepdv cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypepdvDTO result = typepdvService.save(typepdvDTO);
        return ResponseEntity.created(new URI("/api/typepdvs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /typepdvs} : Updates an existing typepdv.
     *
     * @param typepdvDTO the typepdvDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated typepdvDTO,
     * or with status {@code 400 (Bad Request)} if the typepdvDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the typepdvDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/typepdvs")
    public ResponseEntity<TypepdvDTO> updateTypepdv(@Valid @RequestBody TypepdvDTO typepdvDTO) throws URISyntaxException {
        log.debug("REST request to update Typepdv : {}", typepdvDTO);
        if (typepdvDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TypepdvDTO result = typepdvService.save(typepdvDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, typepdvDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /typepdvs} : get all the typepdvs.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of typepdvs in body.
     */
    @GetMapping("/typepdvs")
    public ResponseEntity<List<TypepdvDTO>> getAllTypepdvs(TypepdvCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Typepdvs by criteria: {}", criteria);
        Page<TypepdvDTO> page = typepdvQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /typepdvs/count} : count all the typepdvs.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/typepdvs/count")
    public ResponseEntity<Long> countTypepdvs(TypepdvCriteria criteria) {
        log.debug("REST request to count Typepdvs by criteria: {}", criteria);
        return ResponseEntity.ok().body(typepdvQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /typepdvs/:id} : get the "id" typepdv.
     *
     * @param id the id of the typepdvDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the typepdvDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/typepdvs/{id}")
    public ResponseEntity<TypepdvDTO> getTypepdv(@PathVariable Long id) {
        log.debug("REST request to get Typepdv : {}", id);
        Optional<TypepdvDTO> typepdvDTO = typepdvService.findOne(id);
        return ResponseUtil.wrapOrNotFound(typepdvDTO);
    }

    /**
     * {@code DELETE  /typepdvs/:id} : delete the "id" typepdv.
     *
     * @param id the id of the typepdvDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/typepdvs/{id}")
    public ResponseEntity<Void> deleteTypepdv(@PathVariable Long id) {
        log.debug("REST request to delete Typepdv : {}", id);
        typepdvService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
