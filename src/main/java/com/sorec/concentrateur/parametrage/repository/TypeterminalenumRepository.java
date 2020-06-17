package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Typeterminalenum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Typeterminalenum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeterminalenumRepository extends JpaRepository<Typeterminalenum, Long>, JpaSpecificationExecutor<Typeterminalenum> {
}
