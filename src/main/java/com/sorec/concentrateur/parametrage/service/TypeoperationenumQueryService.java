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

import com.sorec.concentrateur.parametrage.domain.Typeoperationenum;
import com.sorec.concentrateur.parametrage.domain.*; // for static metamodels
import com.sorec.concentrateur.parametrage.repository.TypeoperationenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.TypeoperationenumCriteria;
import com.sorec.concentrateur.parametrage.service.dto.TypeoperationenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.TypeoperationenumMapper;

/**
 * Service for executing complex queries for {@link Typeoperationenum} entities in the database.
 * The main input is a {@link TypeoperationenumCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TypeoperationenumDTO} or a {@link Page} of {@link TypeoperationenumDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TypeoperationenumQueryService extends QueryService<Typeoperationenum> {

    private final Logger log = LoggerFactory.getLogger(TypeoperationenumQueryService.class);

    private final TypeoperationenumRepository typeoperationenumRepository;

    private final TypeoperationenumMapper typeoperationenumMapper;

    public TypeoperationenumQueryService(TypeoperationenumRepository typeoperationenumRepository, TypeoperationenumMapper typeoperationenumMapper) {
        this.typeoperationenumRepository = typeoperationenumRepository;
        this.typeoperationenumMapper = typeoperationenumMapper;
    }

    /**
     * Return a {@link List} of {@link TypeoperationenumDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TypeoperationenumDTO> findByCriteria(TypeoperationenumCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Typeoperationenum> specification = createSpecification(criteria);
        return typeoperationenumMapper.toDto(typeoperationenumRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TypeoperationenumDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TypeoperationenumDTO> findByCriteria(TypeoperationenumCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Typeoperationenum> specification = createSpecification(criteria);
        return typeoperationenumRepository.findAll(specification, page)
            .map(typeoperationenumMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TypeoperationenumCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Typeoperationenum> specification = createSpecification(criteria);
        return typeoperationenumRepository.count(specification);
    }

    /**
     * Function to convert {@link TypeoperationenumCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Typeoperationenum> createSpecification(TypeoperationenumCriteria criteria) {
        Specification<Typeoperationenum> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Typeoperationenum_.id));
            }
            if (criteria.getPari() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPari(), Typeoperationenum_.pari));
            }
            if (criteria.getAnnulation() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAnnulation(), Typeoperationenum_.annulation));
            }
            if (criteria.getPaiement() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPaiement(), Typeoperationenum_.paiement));
            }
        }
        return specification;
    }
}
