package com.sorec.concentrateur.parametrage.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.sorec.concentrateur.parametrage.domain.Pdv;
import com.sorec.concentrateur.parametrage.domain.*; // for static metamodels
import com.sorec.concentrateur.parametrage.repository.PdvRepository;
import com.sorec.concentrateur.parametrage.service.dto.PdvCriteria;
import com.sorec.concentrateur.parametrage.service.dto.PdvDTO;
import com.sorec.concentrateur.parametrage.service.mapper.PdvMapper;

/**
 * Service for executing complex queries for {@link Pdv} entities in the database.
 * The main input is a {@link PdvCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PdvDTO} or a {@link Page} of {@link PdvDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PdvQueryService extends QueryService<Pdv> {

    private final Logger log = LoggerFactory.getLogger(PdvQueryService.class);

    private final PdvRepository pdvRepository;

    private final PdvMapper pdvMapper;

    public PdvQueryService(PdvRepository pdvRepository, PdvMapper pdvMapper) {
        this.pdvRepository = pdvRepository;
        this.pdvMapper = pdvMapper;
    }

    /**
     * Return a {@link List} of {@link PdvDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PdvDTO> findByCriteria(PdvCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Pdv> specification = createSpecification(criteria);
        return pdvMapper.toDto(pdvRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link PdvDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PdvDTO> findByCriteria(PdvCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Pdv> specification = createSpecification(criteria);
        return pdvRepository.findAll(specification, page)
            .map(pdvMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PdvCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Pdv> specification = createSpecification(criteria);
        return pdvRepository.count(specification);
    }

    /**
     * Function to convert {@link PdvCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Pdv> createSpecification(PdvCriteria criteria) {
        Specification<Pdv> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Pdv_.id));
            }
            if (criteria.getNumero() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getNumero(), Pdv_.numero));
            }
            if (criteria.getAgence() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAgence(), Pdv_.agence));
            }
            if (criteria.getDesignation() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDesignation(), Pdv_.designation));
            }
            if (criteria.getVille() != null) {
                specification = specification.and(buildStringSpecification(criteria.getVille(), Pdv_.ville));
            }
            if (criteria.getStatut() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatut(), Pdv_.statut));
            }
        }
        return specification;
    }
}
