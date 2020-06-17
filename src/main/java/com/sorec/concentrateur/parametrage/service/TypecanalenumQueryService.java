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

import com.sorec.concentrateur.parametrage.domain.Typecanalenum;
import com.sorec.concentrateur.parametrage.domain.*; // for static metamodels
import com.sorec.concentrateur.parametrage.repository.TypecanalenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypecanalenumCriteria;
import com.sorec.concentrateur.parametrage.service.dto.TypecanalenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypecanalenumMapper;

/**
 * Service for executing complex queries for {@link Typecanalenum} entities in the database.
 * The main input is a {@link TypecanalenumCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TypecanalenumDTO} or a {@link Page} of {@link TypecanalenumDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TypecanalenumQueryService extends QueryService<Typecanalenum> {

    private final Logger log = LoggerFactory.getLogger(TypecanalenumQueryService.class);

    private final TypecanalenumRepository typecanalenumRepository;

    private final TypecanalenumMapper typecanalenumMapper;

    public TypecanalenumQueryService(TypecanalenumRepository typecanalenumRepository, TypecanalenumMapper typecanalenumMapper) {
        this.typecanalenumRepository = typecanalenumRepository;
        this.typecanalenumMapper = typecanalenumMapper;
    }

    /**
     * Return a {@link List} of {@link TypecanalenumDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TypecanalenumDTO> findByCriteria(TypecanalenumCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Typecanalenum> specification = createSpecification(criteria);
        return typecanalenumMapper.toDto(typecanalenumRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TypecanalenumDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TypecanalenumDTO> findByCriteria(TypecanalenumCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Typecanalenum> specification = createSpecification(criteria);
        return typecanalenumRepository.findAll(specification, page)
            .map(typecanalenumMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TypecanalenumCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Typecanalenum> specification = createSpecification(criteria);
        return typecanalenumRepository.count(specification);
    }

    /**
     * Function to convert {@link TypecanalenumCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Typecanalenum> createSpecification(TypecanalenumCriteria criteria) {
        Specification<Typecanalenum> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Typecanalenum_.id));
            }
            if (criteria.getTerminal() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTerminal(), Typecanalenum_.terminal));
            }
            if (criteria.getOnline() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOnline(), Typecanalenum_.online));
            }
        }
        return specification;
    }
}
