package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.CommandesensibleService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.CommandesensibleDTO;
import com.sorec.concentrateur.parametrage.service.dto.CommandesensibleCriteria;
import com.sorec.concentrateur.parametrage.service.CommandesensibleQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Commandesensible}.
 */
@RestController
@RequestMapping("/api")
public class CommandesensibleResource {

    private final Logger log = LoggerFactory.getLogger(CommandesensibleResource.class);

    private static final String ENTITY_NAME = "parametrageCommandesensible";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CommandesensibleService commandesensibleService;

    private final CommandesensibleQueryService commandesensibleQueryService;

    public CommandesensibleResource(CommandesensibleService commandesensibleService, CommandesensibleQueryService commandesensibleQueryService) {
        this.commandesensibleService = commandesensibleService;
        this.commandesensibleQueryService = commandesensibleQueryService;
    }

    /**
     * {@code POST  /commandesensibles} : Create a new commandesensible.
     *
     * @param commandesensibleDTO the commandesensibleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new commandesensibleDTO, or with status {@code 400 (Bad Request)} if the commandesensible has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/commandesensibles")
    public ResponseEntity<CommandesensibleDTO> createCommandesensible(@Valid @RequestBody CommandesensibleDTO commandesensibleDTO) throws URISyntaxException {
        log.debug("REST request to save Commandesensible : {}", commandesensibleDTO);
        if (commandesensibleDTO.getId() != null) {
            throw new BadRequestAlertException("A new commandesensible cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CommandesensibleDTO result = commandesensibleService.save(commandesensibleDTO);
        return ResponseEntity.created(new URI("/api/commandesensibles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /commandesensibles} : Updates an existing commandesensible.
     *
     * @param commandesensibleDTO the commandesensibleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated commandesensibleDTO,
     * or with status {@code 400 (Bad Request)} if the commandesensibleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the commandesensibleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/commandesensibles")
    public ResponseEntity<CommandesensibleDTO> updateCommandesensible(@Valid @RequestBody CommandesensibleDTO commandesensibleDTO) throws URISyntaxException {
        log.debug("REST request to update Commandesensible : {}", commandesensibleDTO);
        if (commandesensibleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CommandesensibleDTO result = commandesensibleService.save(commandesensibleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, commandesensibleDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /commandesensibles} : get all the commandesensibles.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of commandesensibles in body.
     */
    @GetMapping("/commandesensibles")
    public ResponseEntity<List<CommandesensibleDTO>> getAllCommandesensibles(CommandesensibleCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Commandesensibles by criteria: {}", criteria);
        Page<CommandesensibleDTO> page = commandesensibleQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /commandesensibles/count} : count all the commandesensibles.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/commandesensibles/count")
    public ResponseEntity<Long> countCommandesensibles(CommandesensibleCriteria criteria) {
        log.debug("REST request to count Commandesensibles by criteria: {}", criteria);
        return ResponseEntity.ok().body(commandesensibleQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /commandesensibles/:id} : get the "id" commandesensible.
     *
     * @param id the id of the commandesensibleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the commandesensibleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/commandesensibles/{id}")
    public ResponseEntity<CommandesensibleDTO> getCommandesensible(@PathVariable Long id) {
        log.debug("REST request to get Commandesensible : {}", id);
        Optional<CommandesensibleDTO> commandesensibleDTO = commandesensibleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(commandesensibleDTO);
    }

    /**
     * {@code DELETE  /commandesensibles/:id} : delete the "id" commandesensible.
     *
     * @param id the id of the commandesensibleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/commandesensibles/{id}")
    public ResponseEntity<Void> deleteCommandesensible(@PathVariable Long id) {
        log.debug("REST request to delete Commandesensible : {}", id);
        commandesensibleService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
