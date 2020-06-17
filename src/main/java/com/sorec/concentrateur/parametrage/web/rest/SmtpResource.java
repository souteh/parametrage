package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.SmtpService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.SmtpDTO;
import com.sorec.concentrateur.parametrage.service.dto.SmtpCriteria;
import com.sorec.concentrateur.parametrage.service.SmtpQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Smtp}.
 */
@RestController
@RequestMapping("/api")
public class SmtpResource {

    private final Logger log = LoggerFactory.getLogger(SmtpResource.class);

    private static final String ENTITY_NAME = "parametrageSmtp";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SmtpService smtpService;

    private final SmtpQueryService smtpQueryService;

    public SmtpResource(SmtpService smtpService, SmtpQueryService smtpQueryService) {
        this.smtpService = smtpService;
        this.smtpQueryService = smtpQueryService;
    }

    /**
     * {@code POST  /smtps} : Create a new smtp.
     *
     * @param smtpDTO the smtpDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new smtpDTO, or with status {@code 400 (Bad Request)} if the smtp has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/smtps")
    public ResponseEntity<SmtpDTO> createSmtp(@Valid @RequestBody SmtpDTO smtpDTO) throws URISyntaxException {
        log.debug("REST request to save Smtp : {}", smtpDTO);
        if (smtpDTO.getId() != null) {
            throw new BadRequestAlertException("A new smtp cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SmtpDTO result = smtpService.save(smtpDTO);
        return ResponseEntity.created(new URI("/api/smtps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /smtps} : Updates an existing smtp.
     *
     * @param smtpDTO the smtpDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated smtpDTO,
     * or with status {@code 400 (Bad Request)} if the smtpDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the smtpDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/smtps")
    public ResponseEntity<SmtpDTO> updateSmtp(@Valid @RequestBody SmtpDTO smtpDTO) throws URISyntaxException {
        log.debug("REST request to update Smtp : {}", smtpDTO);
        if (smtpDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SmtpDTO result = smtpService.save(smtpDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, smtpDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /smtps} : get all the smtps.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of smtps in body.
     */
    @GetMapping("/smtps")
    public ResponseEntity<List<SmtpDTO>> getAllSmtps(SmtpCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Smtps by criteria: {}", criteria);
        Page<SmtpDTO> page = smtpQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /smtps/count} : count all the smtps.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/smtps/count")
    public ResponseEntity<Long> countSmtps(SmtpCriteria criteria) {
        log.debug("REST request to count Smtps by criteria: {}", criteria);
        return ResponseEntity.ok().body(smtpQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /smtps/:id} : get the "id" smtp.
     *
     * @param id the id of the smtpDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the smtpDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/smtps/{id}")
    public ResponseEntity<SmtpDTO> getSmtp(@PathVariable Long id) {
        log.debug("REST request to get Smtp : {}", id);
        Optional<SmtpDTO> smtpDTO = smtpService.findOne(id);
        return ResponseUtil.wrapOrNotFound(smtpDTO);
    }

    /**
     * {@code DELETE  /smtps/:id} : delete the "id" smtp.
     *
     * @param id the id of the smtpDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/smtps/{id}")
    public ResponseEntity<Void> deleteSmtp(@PathVariable Long id) {
        log.debug("REST request to delete Smtp : {}", id);
        smtpService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
