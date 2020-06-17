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

import com.sorec.concentrateur.parametrage.domain.Statutticketenum;
import com.sorec.concentrateur.parametrage.domain.*; // for static metamodels
import com.sorec.concentrateur.parametrage.repository.StatutticketenumRepository;
import com.sorec.concentrateur.parametrage.service.dto.StatutticketenumCriteria;
import com.sorec.concentrateur.parametrage.service.dto.StatutticketenumDTO;
import com.sorec.concentrateur.parametrage.service.mapper.StatutticketenumMapper;

/**
 * Service for executing complex queries for {@link Statutticketenum} entities in the database.
 * The main input is a {@link StatutticketenumCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StatutticketenumDTO} or a {@link Page} of {@link StatutticketenumDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StatutticketenumQueryService extends QueryService<Statutticketenum> {

    private final Logger log = LoggerFactory.getLogger(StatutticketenumQueryService.class);

    private final StatutticketenumRepository statutticketenumRepository;

    private final StatutticketenumMapper statutticketenumMapper;

    public StatutticketenumQueryService(StatutticketenumRepository statutticketenumRepository, StatutticketenumMapper statutticketenumMapper) {
        this.statutticketenumRepository = statutticketenumRepository;
        this.statutticketenumMapper = statutticketenumMapper;
    }

    /**
     * Return a {@link List} of {@link StatutticketenumDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StatutticketenumDTO> findByCriteria(StatutticketenumCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Statutticketenum> specification = createSpecification(criteria);
        return statutticketenumMapper.toDto(statutticketenumRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StatutticketenumDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StatutticketenumDTO> findByCriteria(StatutticketenumCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Statutticketenum> specification = createSpecification(criteria);
        return statutticketenumRepository.findAll(specification, page)
            .map(statutticketenumMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StatutticketenumCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Statutticketenum> specification = createSpecification(criteria);
        return statutticketenumRepository.count(specification);
    }

    /**
     * Function to convert {@link StatutticketenumCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Statutticketenum> createSpecification(StatutticketenumCriteria criteria) {
        Specification<Statutticketenum> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Statutticketenum_.id));
            }
            if (criteria.getValide() != null) {
                specification = specification.and(buildStringSpecification(criteria.getValide(), Statutticketenum_.valide));
            }
            if (criteria.getAnnule() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAnnule(), Statutticketenum_.annule));
            }
            if (criteria.getPaye() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPaye(), Statutticketenum_.paye));
            }
            if (criteria.getRembourse() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRembourse(), Statutticketenum_.rembourse));
            }
        }
        return specification;
    }
}
