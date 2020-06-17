package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Statutticketenum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Statutticketenum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StatutticketenumRepository extends JpaRepository<Statutticketenum, Long>, JpaSpecificationExecutor<Statutticketenum> {
}
