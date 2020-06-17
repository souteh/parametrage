package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.AlertemailService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.AlertemailDTO;
import com.sorec.concentrateur.parametrage.service.dto.AlertemailCriteria;
import com.sorec.concentrateur.parametrage.service.AlertemailQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Alertemail}.
 */
@RestController
@RequestMapping("/api")
public class AlertemailResource {

    private final Logger log = LoggerFactory.getLogger(AlertemailResource.class);

    private static final String ENTITY_NAME = "parametrageAlertemail";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AlertemailService alertemailService;

    private final AlertemailQueryService alertemailQueryService;

    public AlertemailResource(AlertemailService alertemailService, AlertemailQueryService alertemailQueryService) {
        this.alertemailService = alertemailService;
        this.alertemailQueryService = alertemailQueryService;
    }

    /**
     * {@code POST  /alertemails} : Create a new alertemail.
     *
     * @param alertemailDTO the alertemailDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new alertemailDTO, or with status {@code 400 (Bad Request)} if the alertemail has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/alertemails")
    public ResponseEntity<AlertemailDTO> createAlertemail(@Valid @RequestBody AlertemailDTO alertemailDTO) throws URISyntaxException {
        log.debug("REST request to save Alertemail : {}", alertemailDTO);
        if (alertemailDTO.getId() != null) {
            throw new BadRequestAlertException("A new alertemail cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AlertemailDTO result = alertemailService.save(alertemailDTO);
        return ResponseEntity.created(new URI("/api/alertemails/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /alertemails} : Updates an existing alertemail.
     *
     * @param alertemailDTO the alertemailDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated alertemailDTO,
     * or with status {@code 400 (Bad Request)} if the alertemailDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the alertemailDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/alertemails")
    public ResponseEntity<AlertemailDTO> updateAlertemail(@Valid @RequestBody AlertemailDTO alertemailDTO) throws URISyntaxException {
        log.debug("REST request to update Alertemail : {}", alertemailDTO);
        if (alertemailDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AlertemailDTO result = alertemailService.save(alertemailDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, alertemailDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /alertemails} : get all the alertemails.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of alertemails in body.
     */
    @GetMapping("/alertemails")
    public ResponseEntity<List<AlertemailDTO>> getAllAlertemails(AlertemailCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Alertemails by criteria: {}", criteria);
        Page<AlertemailDTO> page = alertemailQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /alertemails/count} : count all the alertemails.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/alertemails/count")
    public ResponseEntity<Long> countAlertemails(AlertemailCriteria criteria) {
        log.debug("REST request to count Alertemails by criteria: {}", criteria);
        return ResponseEntity.ok().body(alertemailQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /alertemails/:id} : get the "id" alertemail.
     *
     * @param id the id of the alertemailDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the alertemailDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/alertemails/{id}")
    public ResponseEntity<AlertemailDTO> getAlertemail(@PathVariable Long id) {
        log.debug("REST request to get Alertemail : {}", id);
        Optional<AlertemailDTO> alertemailDTO = alertemailService.findOne(id);
        return ResponseUtil.wrapOrNotFound(alertemailDTO);
    }

    /**
     * {@code DELETE  /alertemails/:id} : delete the "id" alertemail.
     *
     * @param id the id of the alertemailDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/alertemails/{id}")
    public ResponseEntity<Void> deleteAlertemail(@PathVariable Long id) {
        log.debug("REST request to delete Alertemail : {}", id);
        alertemailService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
