package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.AttributaireService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.AttributaireDTO;
import com.sorec.concentrateur.parametrage.service.dto.AttributaireCriteria;
import com.sorec.concentrateur.parametrage.service.AttributaireQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Attributaire}.
 */
@RestController
@RequestMapping("/api")
public class AttributaireResource {

    private final Logger log = LoggerFactory.getLogger(AttributaireResource.class);

    private static final String ENTITY_NAME = "parametrageAttributaire";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AttributaireService attributaireService;

    private final AttributaireQueryService attributaireQueryService;

    public AttributaireResource(AttributaireService attributaireService, AttributaireQueryService attributaireQueryService) {
        this.attributaireService = attributaireService;
        this.attributaireQueryService = attributaireQueryService;
    }

    /**
     * {@code POST  /attributaires} : Create a new attributaire.
     *
     * @param attributaireDTO the attributaireDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new attributaireDTO, or with status {@code 400 (Bad Request)} if the attributaire has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/attributaires")
    public ResponseEntity<AttributaireDTO> createAttributaire(@Valid @RequestBody AttributaireDTO attributaireDTO) throws URISyntaxException {
        log.debug("REST request to save Attributaire : {}", attributaireDTO);
        if (attributaireDTO.getId() != null) {
            throw new BadRequestAlertException("A new attributaire cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AttributaireDTO result = attributaireService.save(attributaireDTO);
        return ResponseEntity.created(new URI("/api/attributaires/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /attributaires} : Updates an existing attributaire.
     *
     * @param attributaireDTO the attributaireDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated attributaireDTO,
     * or with status {@code 400 (Bad Request)} if the attributaireDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the attributaireDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/attributaires")
    public ResponseEntity<AttributaireDTO> updateAttributaire(@Valid @RequestBody AttributaireDTO attributaireDTO) throws URISyntaxException {
        log.debug("REST request to update Attributaire : {}", attributaireDTO);
        if (attributaireDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AttributaireDTO result = attributaireService.save(attributaireDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, attributaireDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /attributaires} : get all the attributaires.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of attributaires in body.
     */
    @GetMapping("/attributaires")
    public ResponseEntity<List<AttributaireDTO>> getAllAttributaires(AttributaireCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Attributaires by criteria: {}", criteria);
        Page<AttributaireDTO> page = attributaireQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /attributaires/count} : count all the attributaires.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/attributaires/count")
    public ResponseEntity<Long> countAttributaires(AttributaireCriteria criteria) {
        log.debug("REST request to count Attributaires by criteria: {}", criteria);
        return ResponseEntity.ok().body(attributaireQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /attributaires/:id} : get the "id" attributaire.
     *
     * @param id the id of the attributaireDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the attributaireDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/attributaires/{id}")
    public ResponseEntity<AttributaireDTO> getAttributaire(@PathVariable Long id) {
        log.debug("REST request to get Attributaire : {}", id);
        Optional<AttributaireDTO> attributaireDTO = attributaireService.findOne(id);
        return ResponseUtil.wrapOrNotFound(attributaireDTO);
    }

    /**
     * {@code DELETE  /attributaires/:id} : delete the "id" attributaire.
     *
     * @param id the id of the attributaireDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/attributaires/{id}")
    public ResponseEntity<Void> deleteAttributaire(@PathVariable Long id) {
        log.debug("REST request to delete Attributaire : {}", id);
        attributaireService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
