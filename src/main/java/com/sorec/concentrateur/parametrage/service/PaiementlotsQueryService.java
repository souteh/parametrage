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

import com.sorec.concentrateur.parametrage.domain.Paiementlots;
import com.sorec.concentrateur.parametrage.domain.*; // for static metamodels
import com.sorec.concentrateur.parametrage.repository.PaiementlotsRepository;
import com.sorec.concentrateur.parametrage.service.dto.PaiementlotsCriteria;
import com.sorec.concentrateur.parametrage.service.dto.PaiementlotsDTO;
import com.sorec.concentrateur.parametrage.service.mapper.PaiementlotsMapper;

/**
 * Service for executing complex queries for {@link Paiementlots} entities in the database.
 * The main input is a {@link PaiementlotsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PaiementlotsDTO} or a {@link Page} of {@link PaiementlotsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PaiementlotsQueryService extends QueryService<Paiementlots> {

    private final Logger log = LoggerFactory.getLogger(PaiementlotsQueryService.class);

    private final PaiementlotsRepository paiementlotsRepository;

    private final PaiementlotsMapper paiementlotsMapper;

    public PaiementlotsQueryService(PaiementlotsRepository paiementlotsRepository, PaiementlotsMapper paiementlotsMapper) {
        this.paiementlotsRepository = paiementlotsRepository;
        this.paiementlotsMapper = paiementlotsMapper;
    }

    /**
     * Return a {@link List} of {@link PaiementlotsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PaiementlotsDTO> findByCriteria(PaiementlotsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Paiementlots> specification = createSpecification(criteria);
        return paiementlotsMapper.toDto(paiementlotsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link PaiementlotsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PaiementlotsDTO> findByCriteria(PaiementlotsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Paiementlots> specification = createSpecification(criteria);
        return paiementlotsRepository.findAll(specification, page)
            .map(paiementlotsMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PaiementlotsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Paiementlots> specification = createSpecification(criteria);
        return paiementlotsRepository.count(specification);
    }

    /**
     * Function to convert {@link PaiementlotsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Paiementlots> createSpecification(PaiementlotsCriteria criteria) {
        Specification<Paiementlots> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Paiementlots_.id));
            }
            if (criteria.getIdlotpaiement() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIdlotpaiement(), Paiementlots_.idlotpaiement));
            }
            if (criteria.getCodepaiement() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodepaiement(), Paiementlots_.codepaiement));
            }
            if (criteria.getType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getType(), Paiementlots_.type));
            }
            if (criteria.getSeuil() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSeuil(), Paiementlots_.seuil));
            }
            if (criteria.getMontantavance() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getMontantavance(), Paiementlots_.montantavance));
            }
            if (criteria.getDelaipurge() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDelaipurge(), Paiementlots_.delaipurge));
            }
            if (criteria.getLieuautorise() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLieuautorise(), Paiementlots_.lieuautorise));
            }
            if (criteria.getLieuannulation() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLieuannulation(), Paiementlots_.lieuannulation));
            }
        }
        return specification;
    }
}
