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

import com.sorec.concentrateur.parametrage.domain.Hypodrome;
import com.sorec.concentrateur.parametrage.domain.*; // for static metamodels
import com.sorec.concentrateur.parametrage.repository.HypodromeRepository;
import com.sorec.concentrateur.parametrage.service.dto.HypodromeCriteria;
import com.sorec.concentrateur.parametrage.service.dto.HypodromeDTO;
import com.sorec.concentrateur.parametrage.service.mapper.HypodromeMapper;

/**
 * Service for executing complex queries for {@link Hypodrome} entities in the database.
 * The main input is a {@link HypodromeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link HypodromeDTO} or a {@link Page} of {@link HypodromeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class HypodromeQueryService extends QueryService<Hypodrome> {

    private final Logger log = LoggerFactory.getLogger(HypodromeQueryService.class);

    private final HypodromeRepository hypodromeRepository;

    private final HypodromeMapper hypodromeMapper;

    public HypodromeQueryService(HypodromeRepository hypodromeRepository, HypodromeMapper hypodromeMapper) {
        this.hypodromeRepository = hypodromeRepository;
        this.hypodromeMapper = hypodromeMapper;
    }

    /**
     * Return a {@link List} of {@link HypodromeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<HypodromeDTO> findByCriteria(HypodromeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Hypodrome> specification = createSpecification(criteria);
        return hypodromeMapper.toDto(hypodromeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link HypodromeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<HypodromeDTO> findByCriteria(HypodromeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Hypodrome> specification = createSpecification(criteria);
        return hypodromeRepository.findAll(specification, page)
            .map(hypodromeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(HypodromeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Hypodrome> specification = createSpecification(criteria);
        return hypodromeRepository.count(specification);
    }

    /**
     * Function to convert {@link HypodromeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Hypodrome> createSpecification(HypodromeCriteria criteria) {
        Specification<Hypodrome> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Hypodrome_.id));
            }
            if (criteria.getIdhypodrome() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIdhypodrome(), Hypodrome_.idhypodrome));
            }
            if (criteria.getCodehypodrome() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCodehypodrome(), Hypodrome_.codehypodrome));
            }
            if (criteria.getAbreviation() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAbreviation(), Hypodrome_.abreviation));
            }
            if (criteria.getPays() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPays(), Hypodrome_.pays));
            }
        }
        return specification;
    }
}
