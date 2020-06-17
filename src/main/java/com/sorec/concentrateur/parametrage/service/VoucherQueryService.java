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

import com.sorec.concentrateur.parametrage.domain.Voucher;
import com.sorec.concentrateur.parametrage.domain.*; // for static metamodels
import com.sorec.concentrateur.parametrage.repository.VoucherRepository;
import com.sorec.concentrateur.parametrage.service.dto.VoucherCriteria;
import com.sorec.concentrateur.parametrage.service.dto.VoucherDTO;
import com.sorec.concentrateur.parametrage.service.mapper.VoucherMapper;

/**
 * Service for executing complex queries for {@link Voucher} entities in the database.
 * The main input is a {@link VoucherCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link VoucherDTO} or a {@link Page} of {@link VoucherDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class VoucherQueryService extends QueryService<Voucher> {

    private final Logger log = LoggerFactory.getLogger(VoucherQueryService.class);

    private final VoucherRepository voucherRepository;

    private final VoucherMapper voucherMapper;

    public VoucherQueryService(VoucherRepository voucherRepository, VoucherMapper voucherMapper) {
        this.voucherRepository = voucherRepository;
        this.voucherMapper = voucherMapper;
    }

    /**
     * Return a {@link List} of {@link VoucherDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<VoucherDTO> findByCriteria(VoucherCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Voucher> specification = createSpecification(criteria);
        return voucherMapper.toDto(voucherRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link VoucherDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<VoucherDTO> findByCriteria(VoucherCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Voucher> specification = createSpecification(criteria);
        return voucherRepository.findAll(specification, page)
            .map(voucherMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(VoucherCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Voucher> specification = createSpecification(criteria);
        return voucherRepository.count(specification);
    }

    /**
     * Function to convert {@link VoucherCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Voucher> createSpecification(VoucherCriteria criteria) {
        Specification<Voucher> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Voucher_.id));
            }
            if (criteria.getIdvoucher() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIdvoucher(), Voucher_.idvoucher));
            }
            if (criteria.getCodevoucher() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCodevoucher(), Voucher_.codevoucher));
            }
            if (criteria.getStatut() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatut(), Voucher_.statut));
            }
            if (criteria.getLieu() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLieu(), Voucher_.lieu));
            }
            if (criteria.getSeuil() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSeuil(), Voucher_.seuil));
            }
            if (criteria.getDelaipurge() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDelaipurge(), Voucher_.delaipurge));
            }
            if (criteria.getPlafond() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPlafond(), Voucher_.plafond));
            }
        }
        return specification;
    }
}
