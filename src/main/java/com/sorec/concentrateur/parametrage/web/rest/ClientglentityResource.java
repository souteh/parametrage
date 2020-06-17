package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.ClientglentityService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.ClientglentityDTO;
import com.sorec.concentrateur.parametrage.service.dto.ClientglentityCriteria;
import com.sorec.concentrateur.parametrage.service.ClientglentityQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Clientglentity}.
 */
@RestController
@RequestMapping("/api")
public class ClientglentityResource {

    private final Logger log = LoggerFactory.getLogger(ClientglentityResource.class);

    private static final String ENTITY_NAME = "parametrageClientglentity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ClientglentityService clientglentityService;

    private final ClientglentityQueryService clientglentityQueryService;

    public ClientglentityResource(ClientglentityService clientglentityService, ClientglentityQueryService clientglentityQueryService) {
        this.clientglentityService = clientglentityService;
        this.clientglentityQueryService = clientglentityQueryService;
    }

    /**
     * {@code POST  /clientglentities} : Create a new clientglentity.
     *
     * @param clientglentityDTO the clientglentityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new clientglentityDTO, or with status {@code 400 (Bad Request)} if the clientglentity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/clientglentities")
    public ResponseEntity<ClientglentityDTO> createClientglentity(@Valid @RequestBody ClientglentityDTO clientglentityDTO) throws URISyntaxException {
        log.debug("REST request to save Clientglentity : {}", clientglentityDTO);
        if (clientglentityDTO.getId() != null) {
            throw new BadRequestAlertException("A new clientglentity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ClientglentityDTO result = clientglentityService.save(clientglentityDTO);
        return ResponseEntity.created(new URI("/api/clientglentities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /clientglentities} : Updates an existing clientglentity.
     *
     * @param clientglentityDTO the clientglentityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated clientglentityDTO,
     * or with status {@code 400 (Bad Request)} if the clientglentityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the clientglentityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/clientglentities")
    public ResponseEntity<ClientglentityDTO> updateClientglentity(@Valid @RequestBody ClientglentityDTO clientglentityDTO) throws URISyntaxException {
        log.debug("REST request to update Clientglentity : {}", clientglentityDTO);
        if (clientglentityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ClientglentityDTO result = clientglentityService.save(clientglentityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, clientglentityDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /clientglentities} : get all the clientglentities.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of clientglentities in body.
     */
    @GetMapping("/clientglentities")
    public ResponseEntity<List<ClientglentityDTO>> getAllClientglentities(ClientglentityCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Clientglentities by criteria: {}", criteria);
        Page<ClientglentityDTO> page = clientglentityQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /clientglentities/count} : count all the clientglentities.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/clientglentities/count")
    public ResponseEntity<Long> countClientglentities(ClientglentityCriteria criteria) {
        log.debug("REST request to count Clientglentities by criteria: {}", criteria);
        return ResponseEntity.ok().body(clientglentityQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /clientglentities/:id} : get the "id" clientglentity.
     *
     * @param id the id of the clientglentityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the clientglentityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/clientglentities/{id}")
    public ResponseEntity<ClientglentityDTO> getClientglentity(@PathVariable Long id) {
        log.debug("REST request to get Clientglentity : {}", id);
        Optional<ClientglentityDTO> clientglentityDTO = clientglentityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(clientglentityDTO);
    }

    /**
     * {@code DELETE  /clientglentities/:id} : delete the "id" clientglentity.
     *
     * @param id the id of the clientglentityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/clientglentities/{id}")
    public ResponseEntity<Void> deleteClientglentity(@PathVariable Long id) {
        log.debug("REST request to delete Clientglentity : {}", id);
        clientglentityService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
