package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Statutenum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Statutenum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StatutenumRepository extends JpaRepository<Statutenum, Long>, JpaSpecificationExecutor<Statutenum> {
}
