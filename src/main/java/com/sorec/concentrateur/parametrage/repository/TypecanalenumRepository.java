package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Typecanalenum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Typecanalenum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypecanalenumRepository extends JpaRepository<Typecanalenum, Long>, JpaSpecificationExecutor<Typecanalenum> {
}
