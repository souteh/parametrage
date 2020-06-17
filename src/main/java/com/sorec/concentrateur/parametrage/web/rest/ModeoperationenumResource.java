package com.sorec.concentrateur.parametrage.web.rest;

import com.sorec.concentrateur.parametrage.service.ModeoperationenumService;
import com.sorec.concentrateur.parametrage.web.rest.errors.BadRequestAlertException;
import com.sorec.concentrateur.parametrage.service.dto.ModeoperationenumDTO;
import com.sorec.concentrateur.parametrage.service.dto.ModeoperationenumCriteria;
import com.sorec.concentrateur.parametrage.service.ModeoperationenumQueryService;

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
 * REST controller for managing {@link com.sorec.concentrateur.parametrage.domain.Modeoperationenum}.
 */
@RestController
@RequestMapping("/api")
public class ModeoperationenumResource {

    private final Logger log = LoggerFactory.getLogger(ModeoperationenumResource.class);

    private static final String ENTITY_NAME = "parametrageModeoperationenum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ModeoperationenumService modeoperationenumService;

    private final ModeoperationenumQueryService modeoperationenumQueryService;

    public ModeoperationenumResource(ModeoperationenumService modeoperationenumService, ModeoperationenumQueryService modeoperationenumQueryService) {
        this.modeoperationenumService = modeoperationenumService;
        this.modeoperationenumQueryService = modeoperationenumQueryService;
    }

    /**
     * {@code POST  /modeoperationenums} : Create a new modeoperationenum.
     *
     * @param modeoperationenumDTO the modeoperationenumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new modeoperationenumDTO, or with status {@code 400 (Bad Request)} if the modeoperationenum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/modeoperationenums")
    public ResponseEntity<ModeoperationenumDTO> createModeoperationenum(@Valid @RequestBody ModeoperationenumDTO modeoperationenumDTO) throws URISyntaxException {
        log.debug("REST request to save Modeoperationenum : {}", modeoperationenumDTO);
        if (modeoperationenumDTO.getId() != null) {
            throw new BadRequestAlertException("A new modeoperationenum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ModeoperationenumDTO result = modeoperationenumService.save(modeoperationenumDTO);
        return ResponseEntity.created(new URI("/api/modeoperationenums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /modeoperationenums} : Updates an existing modeoperationenum.
     *
     * @param modeoperationenumDTO the modeoperationenumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated modeoperationenumDTO,
     * or with status {@code 400 (Bad Request)} if the modeoperationenumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the modeoperationenumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/modeoperationenums")
    public ResponseEntity<ModeoperationenumDTO> updateModeoperationenum(@Valid @RequestBody ModeoperationenumDTO modeoperationenumDTO) throws URISyntaxException {
        log.debug("REST request to update Modeoperationenum : {}", modeoperationenumDTO);
        if (modeoperationenumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ModeoperationenumDTO result = modeoperationenumService.save(modeoperationenumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, modeoperationenumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /modeoperationenums} : get all the modeoperationenums.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of modeoperationenums in body.
     */
    @GetMapping("/modeoperationenums")
    public ResponseEntity<List<ModeoperationenumDTO>> getAllModeoperationenums(ModeoperationenumCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Modeoperationenums by criteria: {}", criteria);
        Page<ModeoperationenumDTO> page = modeoperationenumQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /modeoperationenums/count} : count all the modeoperationenums.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/modeoperationenums/count")
    public ResponseEntity<Long> countModeoperationenums(ModeoperationenumCriteria criteria) {
        log.debug("REST request to count Modeoperationenums by criteria: {}", criteria);
        return ResponseEntity.ok().body(modeoperationenumQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /modeoperationenums/:id} : get the "id" modeoperationenum.
     *
     * @param id the id of the modeoperationenumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the modeoperationenumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/modeoperationenums/{id}")
    public ResponseEntity<ModeoperationenumDTO> getModeoperationenum(@PathVariable Long id) {
        log.debug("REST request to get Modeoperationenum : {}", id);
        Optional<ModeoperationenumDTO> modeoperationenumDTO = modeoperationenumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(modeoperationenumDTO);
    }

    /**
     * {@code DELETE  /modeoperationenums/:id} : delete the "id" modeoperationenum.
     *
     * @param id the id of the modeoperationenumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/modeoperationenums/{id}")
    public ResponseEntity<Void> deleteModeoperationenum(@PathVariable Long id) {
        log.debug("REST request to delete Modeoperationenum : {}", id);
        modeoperationenumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
