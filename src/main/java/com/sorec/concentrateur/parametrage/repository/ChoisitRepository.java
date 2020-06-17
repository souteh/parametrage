package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Choisit;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Choisit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ChoisitRepository extends JpaRepository<Choisit, Long>, JpaSpecificationExecutor<Choisit> {
}
