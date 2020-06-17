package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.ChoisitService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.ChoisitDTO;
import com.sorec.concentrateur.parametrage.service.dto.ChoisitCriteria;
import com.sorec.concentrateur.parametrage.service.ChoisitQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Choisit}.
 */
@RestController
@RequestMapping("/api")
public class ChoisitResource {

    private final Logger log = LoggerFactory.getLogger(ChoisitResource.class);

    private static final String ENTITY_NAME = "parametrageChoisit";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ChoisitService choisitService;

    private final ChoisitQueryService choisitQueryService;

    public ChoisitResource(ChoisitService choisitService, ChoisitQueryService choisitQueryService) {
        this.choisitService = choisitService;
        this.choisitQueryService = choisitQueryService;
    }

    /**
     * {@code POST  /choisits} : Create a new choisit.
     *
     * @param choisitDTO the choisitDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new choisitDTO, or with status {@code 400 (Bad Request)} if the choisit has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/choisits")
    public ResponseEntity<ChoisitDTO> createChoisit(@Valid @RequestBody ChoisitDTO choisitDTO) throws URISyntaxException {
        log.debug("REST request to save Choisit : {}", choisitDTO);
        if (choisitDTO.getId() != null) {
            throw new BadRequestAlertException("A new choisit cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ChoisitDTO result = choisitService.save(choisitDTO);
        return ResponseEntity.created(new URI("/api/choisits/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /choisits} : Updates an existing choisit.
     *
     * @param choisitDTO the choisitDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated choisitDTO,
     * or with status {@code 400 (Bad Request)} if the choisitDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the choisitDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/choisits")
    public ResponseEntity<ChoisitDTO> updateChoisit(@Valid @RequestBody ChoisitDTO choisitDTO) throws URISyntaxException {
        log.debug("REST request to update Choisit : {}", choisitDTO);
        if (choisitDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ChoisitDTO result = choisitService.save(choisitDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, choisitDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /choisits} : get all the choisits.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of choisits in body.
     */
    @GetMapping("/choisits")
    public ResponseEntity<List<ChoisitDTO>> getAllChoisits(ChoisitCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Choisits by criteria: {}", criteria);
        Page<ChoisitDTO> page = choisitQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /choisits/count} : count all the choisits.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/choisits/count")
    public ResponseEntity<Long> countChoisits(ChoisitCriteria criteria) {
        log.debug("REST request to count Choisits by criteria: {}", criteria);
        return ResponseEntity.ok().body(choisitQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /choisits/:id} : get the "id" choisit.
     *
     * @param id the id of the choisitDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the choisitDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/choisits/{id}")
    public ResponseEntity<ChoisitDTO> getChoisit(@PathVariable Long id) {
        log.debug("REST request to get Choisit : {}", id);
        Optional<ChoisitDTO> choisitDTO = choisitService.findOne(id);
        return ResponseUtil.wrapOrNotFound(choisitDTO);
    }

    /**
     * {@code DELETE  /choisits/:id} : delete the "id" choisit.
     *
     * @param id the id of the choisitDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/choisits/{id}")
    public ResponseEntity<Void> deleteChoisit(@PathVariable Long id) {
        log.debug("REST request to delete Choisit : {}", id);
        choisitService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
