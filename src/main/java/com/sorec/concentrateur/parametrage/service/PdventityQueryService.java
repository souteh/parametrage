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

import com.sorec.concentrateur.parametrage.domain.Pdventity;
import com.sorec.concentrateur.parametrage.domain.*; // for static metamodels
import com.sorec.concentrateur.parametrage.repository.PdventityRepository;
import com.sorec.concentrateur.parametrage.service.dto.PdventityCriteria;
import com.sorec.concentrateur.parametrage.service.dto.PdventityDTO;
import com.sorec.concentrateur.parametrage.service.mapper.PdventityMapper;

/**
 * Service for executing complex queries for {@link Pdventity} entities in the database.
 * The main input is a {@link PdventityCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PdventityDTO} or a {@link Page} of {@link PdventityDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PdventityQueryService extends QueryService<Pdventity> {

    private final Logger log = LoggerFactory.getLogger(PdventityQueryService.class);

    private final PdventityRepository pdventityRepository;

    private final PdventityMapper pdventityMapper;

    public PdventityQueryService(PdventityRepository pdventityRepository, PdventityMapper pdventityMapper) {
        this.pdventityRepository = pdventityRepository;
        this.pdventityMapper = pdventityMapper;
    }

    /**
     * Return a {@link List} of {@link PdventityDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PdventityDTO> findByCriteria(PdventityCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Pdventity> specification = createSpecification(criteria);
        return pdventityMapper.toDto(pdventityRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link PdventityDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PdventityDTO> findByCriteria(PdventityCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Pdventity> specification = createSpecification(criteria);
        return pdventityRepository.findAll(specification, page)
            .map(pdventityMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PdventityCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Pdventity> specification = createSpecification(criteria);
        return pdventityRepository.count(specification);
    }

    /**
     * Function to convert {@link PdventityCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Pdventity> createSpecification(PdventityCriteria criteria) {
        Specification<Pdventity> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Pdventity_.id));
            }
            if (criteria.getIdpdv() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIdpdv(), Pdventity_.idpdv));
            }
            if (criteria.getReferencepdv() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferencepdv(), Pdventity_.referencepdv));
            }
        }
        return specification;
    }
}
