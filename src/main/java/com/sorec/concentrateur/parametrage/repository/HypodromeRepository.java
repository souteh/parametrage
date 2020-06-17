package com.sorec.concentrateur.parametrage.repository;

import com.sorec.concentrateur.parametrage.domain.Hypodrome;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Hypodrome entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HypodromeRepository extends JpaRepository<Hypodrome, Long>, JpaSpecificationExecutor<Hypodrome> {
}
